package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;
import wanzhi.gulu.community.dto.*;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyProfileController {

    @Autowired
    UserService userService;

    //到个人信息页面
    @GetMapping("/myProfile")
    public String toMyProfile(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        return "myProfile";
    }

    //绑定手机号
    @ResponseBody
    @PostMapping("/bindingPhone")
    public Object bindingPhone(@RequestBody BindingDTO bindingDTO,
                                  HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        if (loginUser.getPhone()!=null){
            throw new CustomizeException(CustomizeErrorCode.PHONE_HAS);
        }
        Boolean phoneIsExist = userService.checkPhone(bindingDTO.getData());
        if (phoneIsExist){
            throw new CustomizeException(CustomizeErrorCode.PHONE_ALREADY_EXIST);
        }
        loginUser.setPhone(bindingDTO.getData());
        userService.binding(loginUser);
        return ResultDTO.okOf();
    }

    //绑定github账户功能在AuthorizeController中，state=2

    //绑定email功能
    @ResponseBody
    @PostMapping("/bindingEmail")
    public Object bindingEmail(@RequestBody BindingDTO bindingDTO,
                               HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        loginUser.setEmail(bindingDTO.getData());
        userService.binding(loginUser);
        return ResultDTO.okOf();
    }

    //设置密码功能
    @ResponseBody
    @PostMapping("/bindingPassword")
    public Object bindingPassword(@RequestBody BindingDTO bindingDTO,
                                  HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        if (loginUser.getPhone()==null){
            throw new CustomizeException(CustomizeErrorCode.PHONE_NOT_BINDING);
        }
        loginUser.setPassword(bindingDTO.getData());
        userService.binding(loginUser);
        return ResultDTO.okOf();
    }


}
