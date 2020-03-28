package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.dto.UserDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.Question;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.QuestionService;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    //到用户详情
    @GetMapping("/user")
    public String showUser(@RequestParam("id") Long id,
                           @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                           Model model,
                           HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        UserDTO userDTO =userService.findUserDTOByid(id,loginUser.getId());
        PageDTO pageDTO = questionService.findPageByUserId(currentPage,id);
        model.addAttribute("pageDTO",pageDTO);
        model.addAttribute("userDTO",userDTO);
        return "user";
    }
}
