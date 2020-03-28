package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.security.util.Password;
import wanzhi.gulu.community.dto.*;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.provider.UcloudProvider;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MyProfileController {

    @Autowired
    UserService userService;

    @Autowired
    UcloudProvider ucloudProvider;

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

    @PostMapping("/updateBio")
    public String bindingBio(@RequestParam("bio")String bio,
                             HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        loginUser.setBio(bio);
        userService.binding(loginUser);
        return "redirect:/myProfile";
    }

    //升级会员
    @ResponseBody
    @PostMapping("/vip")
    public Object VIP(@RequestBody BindingDTO bindingDTO,
                      HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        if ("咕噜会员".equals(bindingDTO.getData())){
            loginUser.setPower(1);
            userService.binding(loginUser);
            return ResultDTO.okOf();
        }
        return ResultDTO.errorOf("会员密码不正确！");
    }

    //更换头像
    @ResponseBody
    @PostMapping("/updateAvatar")
    public Object fileUpload(HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest) request;
        //使用multipartRequest接收图片
        MultipartFile file = multipartRequest.getFile("file");
        try {
            String url = ucloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
            //图片在服务器存储的地址
            loginUser.setAvatarUrl(url);
            userService.binding(loginUser);
            return ResultDTO.okOf();
            //当前端显示图片地址的时候，图片就已经上传到UCloud了
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultDTO.errorOf("更换头像失败！");
    }

}
