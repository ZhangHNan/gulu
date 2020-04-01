package wanzhi.gulu.community.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.dto.QuestionDTO;
import wanzhi.gulu.community.enums.PraiseTypeEnum;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.mapper.*;
import wanzhi.gulu.community.model.*;
import wanzhi.gulu.community.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    AppealMapper appealMapper;

    @Autowired
    UserService userService;

    @Autowired
    PageUtils pageUtils;

    @Autowired
    PraiseUtils praiseUtils;

    @Autowired
    TreadUtils treadUtils;

    @Autowired
    StarUtils starUtils;

    @Autowired
    HotUtils hotUtils;

    @Value("${page.index.rows}")
    private Integer indexRows;//设置首页每页展示数据行数

    @Value("${page.index.buttonCount}")
    private Integer indexButtonCount;//设置首页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个

    @Value("${page.question.rows}")
    private Integer questionRows;//设置我的问题页每页展示数据行数

    @Value("${page.question.buttonCount}")
    private Integer questionButtonCount;//设置我的问题页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个


    //首页查询帖子并作分页
    public PageDTO findPage(Integer currentPage, String search) {
        //传入要跳转的页面、每页显示数据条数、每页显示指定到某页的按钮数即可自动构建pageDTO对象并返回
        return pageUtils.autoStructureQuestionPageDTO(currentPage, indexRows, indexButtonCount,search);
    }

    //我的问题页分页查询帖子
    public PageDTO findPageByCreator(Integer currentPage, Long id) {
        return pageUtils.autoStructureQuestionPageDTOByCreator(currentPage, questionRows, questionButtonCount, id);
    }

    //用户详情页面
    public PageDTO findPageByUserId(Integer currentPage, Long id) {
        return pageUtils.autoStructureQuestionPageDTOByCreator(currentPage, questionRows, questionButtonCount, id);
    }

    //根据id查询QuestionDTO ：到问题详情页时
    public QuestionDTO findQuestionById(Long id,Long loginId) {
//        QuestionDTO questionDTO = questionMapper.findById(id);
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question==null){//如果查询一个没有的帖子，抛一个自定义的异常
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
//        User user = userMapper.findById(questionDTO.getCreator());
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        if (loginId != null){
            questionDTO.setPraiseStatus(praiseUtils.getStatus(id,loginId,PraiseTypeEnum.QUESTION.getType()));
            questionDTO.setTreadStatus(treadUtils.getStatus(id,loginId,PraiseTypeEnum.QUESTION.getType()));
            questionDTO.setStarStatus(starUtils.getStatus(id,loginId));
        }else{
            questionDTO.setPraiseStatus(0);
            questionDTO.setTreadStatus(0);
            questionDTO.setStarStatus(0);
        }
        return questionDTO;
    }


    //更新或创建帖子 ： 发布或编辑问题功能
    @Transactional
    public void updateOrCreate(Question question,Long loginId) {
        if(question.getId()==null){
//            questionMapper.create(question);
            question.setGmtCreate(question.getGmtModified());
            //创建帖子
            //增加热度值
            hotUtils.incUserHot(loginId,10L);
            questionMapper.insertSelective(question);
        }else {
//            questionMapper.update(question);
            //修改帖子
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                    .andIdEqualTo(question.getId());
            questionMapper.updateByExampleSelective(question, questionExample);
        }
    }

    //增加阅读数
    @Transactional
    public void view(Long id, Long loginId) {
//        Question question = questionMapper.selectByPrimaryKey(id);
//        Question updateQuestion = new Question();
//        updateQuestion.setViewCount(question.getViewCount()+1);
//        QuestionExample example = new QuestionExample();
//        example.createCriteria()
//                .andIdEqualTo(id);
//        questionMapper.updateByExampleSelective(updateQuestion, example);
        Question question = questionMapper.selectByPrimaryKey(id);
        Long creator = question.getCreator();
        if (creator.equals(loginId)){//自己访问自己不增加浏览量和热度值
            return;
        }
        Question updateQuestion = new Question();
        updateQuestion.setId(id);
        updateQuestion.setViewCount(1L);
        questionExtMapper.incView(updateQuestion);
        hotUtils.incQuestionHot(id,1L);
        hotUtils.incUserHot(creator,1L);
    }

    //查询相关问题
    public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())){
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regxpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regxpTag);
        List<Question> questions = questionExtMapper.selectRelated(question);
        List<QuestionDTO> questionDTOS = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q,questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOS;
    }

    public Integer findQuestionCountByCreator(Long id) {
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(id);
        int count = questionMapper.countByExample(example);
        return count;
    }

    public PageDTO findPageByStar(Integer currentPage, Long id) {
        return pageUtils.autoStructureQuestionPageDTOByStar(currentPage,questionRows,questionButtonCount,id);
    }

    public void cancelBan(Long appealId) {
        Appeal appeal = appealMapper.selectByPrimaryKey(appealId);
        Question question = questionMapper.selectByPrimaryKey(appeal.getQuestionId());
        question.setBan(0);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(appeal.getQuestionId());
        questionMapper.updateByExample(question, questionExample);
    }
}
