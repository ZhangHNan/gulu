package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.CommentResultDTO;
import wanzhi.gulu.community.enums.NotificationStatusEnum;
import wanzhi.gulu.community.enums.NotificationTypeEnum;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.mapper.CommentMapper;
import wanzhi.gulu.community.mapper.NotificationMapper;
import wanzhi.gulu.community.mapper.UserMapper;
import wanzhi.gulu.community.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    //已读通知操作：改变通知状态，同时跳转到相应的question页面
    @GetMapping("/read")
    public String read(@RequestParam("id") Long id,
                       @RequestParam("type") Integer type,
                       @RequestParam("outerId")Long outerId,
                       @RequestParam(name="myAppeal",required = false)Boolean myAppeal){
        //标为已读
        signRead(id);
        if (type==NotificationTypeEnum.REPLY_COMMENT.getType()){

            //查询outerId对应的questionId
            Comment comment = commentMapper.selectByPrimaryKey(outerId);
            Long parentId = comment.getTargetId();
            //跳转
            return "forward:/question/"+parentId;
        }
        if (type==NotificationTypeEnum.WATCH_FOR.getType()){
            return "forward:/myProfile";
        }
        //其他的
        if (myAppeal!=null&&myAppeal==true){
            return "forward:/myAppeal";
        }
        if (type==NotificationTypeEnum.FOREVER_BAN.getType() ||
                type==NotificationTypeEnum.CANCEL_APPEAL.getType() ||
                type==NotificationTypeEnum.APPEAL_FAIL.getType() ){
            return "redirect:/myMessage";
        }
        return "forward:/question/"+outerId;
    }

    private void signRead(Long id){
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andIdEqualTo(id);
        notificationMapper.updateByExample(notification, example);
    }

    @GetMapping("/allRead")
    public String allRead(HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null) {
            //用户未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(loginUser.getId());
        List<Notification> notifications = notificationMapper.selectByExample(example);
        for (Notification n : notifications){
            signRead(n.getId());
        }
        return "redirect:/myMessage";
    }
}
