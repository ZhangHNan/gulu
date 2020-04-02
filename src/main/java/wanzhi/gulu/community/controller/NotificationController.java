package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.enums.NotificationStatusEnum;
import wanzhi.gulu.community.enums.NotificationTypeEnum;
import wanzhi.gulu.community.mapper.CommentMapper;
import wanzhi.gulu.community.mapper.NotificationMapper;
import wanzhi.gulu.community.model.Comment;
import wanzhi.gulu.community.model.Notification;
import wanzhi.gulu.community.model.NotificationExample;

@Controller
public class NotificationController {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    CommentMapper commentMapper;

    //已读通知操作：改变通知状态，同时跳转到相应的question页面
    @GetMapping("/read")
    public String read(@RequestParam("id") Long id,
                       @RequestParam("type") Integer type,
                       @RequestParam("outerId")Long outerId){
        if (type==NotificationTypeEnum.REPLY_QUESTION.getType()){
            //标为已读
            Notification notification = notificationMapper.selectByPrimaryKey(id);
            notification.setStatus(NotificationStatusEnum.READ.getStatus());
            NotificationExample example = new NotificationExample();
            example.createCriteria()
                    .andIdEqualTo(id);
            notificationMapper.updateByExample(notification, example);
            return "forward:/question/"+outerId;
        }else{
            //标为已读
            Notification notification = notificationMapper.selectByPrimaryKey(id);
            notification.setStatus(NotificationStatusEnum.READ.getStatus());
            NotificationExample example = new NotificationExample();
            example.createCriteria()
                    .andIdEqualTo(id);
            notificationMapper.updateByExample(notification, example);
            //查询outerId对应的questionId
            Comment comment = commentMapper.selectByPrimaryKey(outerId);
            Long parentId = comment.getTargetId();
            //跳转
            return "forward:/question/"+parentId;
        }
    }
}
