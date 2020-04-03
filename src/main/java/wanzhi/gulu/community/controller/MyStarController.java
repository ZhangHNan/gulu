package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.check.LoginCheck;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyStarController {

    @Autowired
    LoginCheck loginCheck;

    @Autowired
    QuestionService questionService;

    //到我的收藏页面
    @GetMapping("/myStar")
    public String myStar(Model model,
                          @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                          HttpServletRequest request){
        //从session域中获取登录的user
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录重定向到首页，注意：如果是“redirect:index”，它会跳转到同级的index。即/profile/index
            return "redirect:/index";
        }
        PageDTO pageDTO = questionService.findPageByStar(currentPage,loginUser.getId());
        model.addAttribute("pageDTO",pageDTO);
        return "myStar";
    }
}
