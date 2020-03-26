package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wanzhi.gulu.community.dto.CommentDTO;
import wanzhi.gulu.community.dto.QuestionDTO;
import wanzhi.gulu.community.enums.CommentTypeEnum;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.CommentService;
import wanzhi.gulu.community.service.QuestionService;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    //到问题详情页面
    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Long id,
                           HttpServletRequest request,
                           Model model){
        User user = (User)request.getSession().getAttribute("user");
        Long loginId = null;
        List<CommentDTO> commentDTOs;
        QuestionDTO questionDTO;
        if (user!=null){
            loginId = user.getId();
            //累计阅读数和热度值
            questionService.view(id,loginId);
            commentDTOs = commentService.listByTargetId(id,CommentTypeEnum.QUESTION,loginId);
            questionDTO = questionService.findQuestionById(id,loginId);
        }else{
            questionService.view(id,null);
            commentDTOs = commentService.listByTargetId(id,CommentTypeEnum.QUESTION,null);
            questionDTO = questionService.findQuestionById(id,null);
        }

        List<QuestionDTO> relatedQuestionDTOS = questionService.selectRelated(questionDTO);
        model.addAttribute("questionDTO",questionDTO);
        model.addAttribute("commentDTOS",commentDTOs);
        model.addAttribute("relatedQuestionDTOS",relatedQuestionDTOS);
        return "question";
    }
}
