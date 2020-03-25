package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wanzhi.gulu.community.dto.CommentResultDTO;
import wanzhi.gulu.community.dto.PraiseCreateDTO;
import wanzhi.gulu.community.dto.PraiseResultDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.PraisesService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PraisesController {

    @Autowired
    PraisesService praisesService;

    @ResponseBody
    @PostMapping("/questionPraise")
    public Object questionPraise(@RequestBody PraiseCreateDTO praiseCreateDTO,
                                 HttpServletRequest request){//注意，这里type必须是1 问题
        //如果未登录提示登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            //用户未登录
            return CommentResultDTO.errorOf(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //先验证type是否正确
        if (praiseCreateDTO.getType()!=1){
            throw new CustomizeException(CustomizeErrorCode.PRAISE_TYPE_ERROR);
        }

        Praise praise = praisesService.checkPraiseStatus(praiseCreateDTO);
        Integer status;
        if (praise==null){
            praisesService.createQuestionPraise(praiseCreateDTO);
            status = 1;
        }else {
            praisesService.removeQuestionPraise(praise);
            status = 0;
        }
        return PraiseResultDTO.okOf(status);
    }

    @ResponseBody
    @PostMapping("/commentPraise")
    public Object commentPraise(@RequestBody PraiseCreateDTO praiseCreateDTO,
                                HttpServletRequest request){//注意，这里type必须是2 评论
        //如果未登录提示登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            //用户未登录
            return CommentResultDTO.errorOf(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //先验证type是否正确
        if (praiseCreateDTO.getType()!=2){
            throw new CustomizeException(CustomizeErrorCode.PRAISE_TYPE_ERROR);
        }

        Praise praise = praisesService.checkPraiseStatus(praiseCreateDTO);
        Integer status;
        if (praise==null){
            praisesService.createCommentPraise(praiseCreateDTO);
            status = 1;
        }else {
            praisesService.removeCommentPraise(praise);
            status = 0;
        }
        return PraiseResultDTO.okOf(status);
    }
}
