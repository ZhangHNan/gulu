package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyWatchController {

    @Autowired
    UserService userService;

    //到我的关注页面
    @GetMapping("/myWatch")
    public String toMyWatch(Model model,
                            @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                            HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            //如果未登录重定向到首页，注意：如果是“redirect:index”，它会跳转到同级的index。即/profile/index
            return "redirect:/index";
        }
        PageDTO pageDTO = userService.findPageByWatch(currentPage,user.getId());
        model.addAttribute("pageDTO",pageDTO);
        return "myWatch";
    }
}
