package wanzhi.gulu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.CommentDTO;
import wanzhi.gulu.community.enums.CommentTypeEnum;
import wanzhi.gulu.community.enums.NotificationStatusEnum;
import wanzhi.gulu.community.enums.NotificationTypeEnum;
import wanzhi.gulu.community.enums.PraiseTypeEnum;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.mapper.*;
import wanzhi.gulu.community.model.*;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.PraiseUtils;
import wanzhi.gulu.community.util.TreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    HotUtils hotUtils;

    @Autowired
    PraiseUtils praiseUtils;

    @Autowired
    TreadUtils treadUtils;

    @Autowired
    CommentExtMapper commentExtMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    NotificationMapper notificationMapper;

    //添加评论功能
    @Transactional//增加事务
    public void insert(Comment comment) {
        if (comment.getTargetId() == null || comment.getTargetId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_ERROR);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_ERROR);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getTargetId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            //增加评论的评论数
            Comment updateComment = new Comment();
            updateComment.setId(comment.getTargetId());
            updateComment.setCommentCount(1L);
            commentMapper.insertSelective(comment);
            commentExtMapper.incCommentCount(updateComment);
            hotUtils.incCommentHot(dbComment.getId(),1L);
            //创建通知
            createCommentNotify(comment,dbComment.getCommentator(), NotificationTypeEnum.REPLY_COMMENT);
        } else {
            //回复问题
            Question dbQuestion = questionMapper.selectByPrimaryKey(comment.getTargetId());
            if (dbQuestion == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            dbQuestion.setCommentCount(1L);
            questionExtMapper.incCommentCount(dbQuestion);
            commentMapper.insertSelective(comment);
            //增加热力值
            hotUtils.incQuestionHot(dbQuestion.getId(),1L);
            hotUtils.incUserHot(dbQuestion.getCreator(),1L);
            //创建通知
            createCommentNotify(comment,dbQuestion.getCreator(), NotificationTypeEnum.REPLY_QUESTION);
        }
    }

    //创建评论通知：传入被评论对象，以及评论人id，和评论类型即可
    private void createCommentNotify(Comment comment, Long receiver, NotificationTypeEnum notificationTypeEnum) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationTypeEnum.getType());
        notification.setOuterId(comment.getTargetId());
        notification.setNotifier(comment.getCommentator());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiver);
        //注意：这里传入的comment是null，可以利用创建时间唯一性来从数据库中查找相应的comment
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andGmtCreateEqualTo(comment.getGmtCreate());
        List<Comment> comments = commentMapper.selectByExample(example);
        if (notificationTypeEnum.getType() == NotificationTypeEnum.REPLY_QUESTION.getType()) {
            Question targetQuestion = questionMapper.selectByPrimaryKey(comment.getTargetId());
            if (targetQuestion.getTitle().length()>10){
                String substring = targetQuestion.getTitle().substring(0, 9);
                String titleShort = substring + "...";
                notification.setOuterTitle(titleShort);
            }else{
                notification.setOuterTitle(targetQuestion.getTitle());
            }
            notification.setTypeName(NotificationTypeEnum.REPLY_QUESTION.getName());
        } else {
            Comment targetComment = commentMapper.selectByPrimaryKey(comment.getTargetId());
            if (targetComment.getContent().length()>10){
                String substring = targetComment.getContent().substring(0, 9);
                String titleShort = substring + "...";
                notification.setOuterTitle(titleShort);
            }else{
                notification.setOuterTitle(comment.getContent());
            }
            notification.setTypeName(NotificationTypeEnum.REPLY_COMMENT.getName());
        }
        if (comments.size()!=0){
            notification.setSourceId(comments.get(0).getId());
        }
        notificationMapper.insert(notification);
    }

    //查询评论功能
    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type,Long loginId) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andTargetIdEqualTo(id)
                .andTypeEqualTo(type.getType());
        example.setOrderByClause("gmt_create desc");//按照创建时间倒叙查询
        //根据ParentId查询问题评论
        List<Comment> comments = commentMapper.selectByExample(example);
        if (comments.size() == 0) {
            return new ArrayList<>();
        }
        //获取去重的评论人
        Set<Long> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(commentators);

        //获取评论人并转换为Map
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);

        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        //转换comment为commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            if (loginId!=null){
                commentDTO.setPraiseStatus(praiseUtils.getStatus(commentDTO.getId(),loginId,PraiseTypeEnum.COMMENT.getType()));
                commentDTO.setTreadStatus(treadUtils.getStatus(commentDTO.getId(),loginId,PraiseTypeEnum.COMMENT.getType()));
            } else{
                commentDTO.setPraiseStatus(0);
                commentDTO.setTreadStatus(0);
            }
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;
    }
}
