package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import wanzhi.gulu.community.dto.CommentResultDTO;
import wanzhi.gulu.community.dto.PTSWResultDTO;
import wanzhi.gulu.community.dto.PraiseCreateDTO;
import wanzhi.gulu.community.dto.TreadCreateDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.Tread;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.PraisesService;
import wanzhi.gulu.community.service.TreadService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TreadController {

    @Autowired
    TreadService treadService;

    @ResponseBody
    @PostMapping("/questionTread")
    public Object questionTread(@RequestBody TreadCreateDTO treadCreateDTO,
                                 HttpServletRequest request){//注意，这里type必须是1 问题
        //如果未登录提示登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            //用户未登录
            return CommentResultDTO.errorOf(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //先验证type是否正确
        if (treadCreateDTO.getType()!=1){
            throw new CustomizeException(CustomizeErrorCode.TREAD_TYPE_ERROR);
        }

        Tread tread = treadService.checkTreadStatus(treadCreateDTO);
        Integer status;
        Long queTreCount;
        if (tread==null){
            //点踩
            queTreCount = treadService.createQuestionTread(treadCreateDTO);
            status = 1;
        }else {
            //取消踩
            queTreCount = treadService.removeQuestionTread(tread);
            status = 0;
        }
        return PTSWResultDTO.okOf(status,queTreCount);
    }

    @ResponseBody
    @PostMapping("/commentTread")
    public Object commentTread(@RequestBody TreadCreateDTO treadCreateDTO,
                                HttpServletRequest request){//注意，这里type必须是2 评论
        //如果未登录提示登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            //用户未登录
            return CommentResultDTO.errorOf(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //先验证type是否正确
        if (treadCreateDTO.getType()!=2){
            throw new CustomizeException(CustomizeErrorCode.TREAD_TYPE_ERROR);
        }

        Tread tread = treadService.checkTreadStatus(treadCreateDTO);
        Integer status;
        Long comTreCount;
        if (tread==null){
            //点赞
            comTreCount=treadService.createCommentTread(treadCreateDTO);
            status = 1;
        }else {
            //取消点赞
            comTreCount=treadService.removeCommentTread(tread);
            status = 0;
        }
        return PTSWResultDTO.okOf(status,comTreCount);
    }
}
