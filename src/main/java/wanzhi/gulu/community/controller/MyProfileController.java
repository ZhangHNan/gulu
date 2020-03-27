package wanzhi.gulu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyProfileController {

    @GetMapping("/myProfile")
    public String toMyProfile(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        return "myProfile";
    }
}
