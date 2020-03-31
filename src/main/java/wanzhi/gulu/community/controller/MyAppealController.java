package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.AppealService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyAppealController {

    @Autowired
    AppealService appealService;

    @GetMapping("/myAppeal")
    public String toAppeal(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                           HttpServletRequest request,
                           Model model){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        PageDTO pageDTO =appealService.findMyAppealPageById(currentPage,loginUser.getId());
        model.addAttribute("pageDTO",pageDTO);
        return "myAppeal";
    }
}
