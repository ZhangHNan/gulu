package wanzhi.gulu.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import wanzhi.gulu.community.dto.RegisterDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.mapper.UserMapper;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.model.UserExample;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    //注册功能
    @PostMapping("/register")
    public String register(RegisterDTO RegisterDTO,
                           Model model){
        //验证手机号是否注册过
        UserExample example = new UserExample();
        example.createCriteria()
                .andPhoneEqualTo(RegisterDTO.getPhone());
        List<User> users = userMapper.selectByExample(example);
        if(users.size()!=0){
            //回显并携带错误信息
            model.addAttribute("phone", RegisterDTO.getPhone());
            model.addAttribute("name", RegisterDTO.getName());
            model.addAttribute("email", RegisterDTO.getEmail());
            model.addAttribute("password", RegisterDTO.getPassword());
            model.addAttribute("passwordAgain", RegisterDTO.getPasswordAgain());
            model.addAttribute("msg",CustomizeErrorCode.PHONE_ALREADY_EXIST.getMassage());
            return "register";
        }
        //手机验证码通过后才执行下面语句

        //验证用户名是否为空
        if (StringUtils.isBlank(RegisterDTO.getName())){
            //回显并携带错误信息
            model.addAttribute("phone", RegisterDTO.getPhone());
            model.addAttribute("name", RegisterDTO.getName());
            model.addAttribute("email", RegisterDTO.getEmail());
            model.addAttribute("password", RegisterDTO.getPassword());
            model.addAttribute("passwordAgain", RegisterDTO.getPasswordAgain());
            model.addAttribute("msg",CustomizeErrorCode.NAME_IS_EMPTY.getMassage());
            return "register";
        }

        //验证输入密码与再次输入密码是否一致
        if (!RegisterDTO.getPassword().equals(RegisterDTO.getPasswordAgain())){
            //回显并携带错误信息
            model.addAttribute("phone", RegisterDTO.getPhone());
            model.addAttribute("name", RegisterDTO.getName());
            model.addAttribute("email", RegisterDTO.getEmail());
            model.addAttribute("password", RegisterDTO.getPassword());
            model.addAttribute("passwordAgain", RegisterDTO.getPasswordAgain());
            model.addAttribute("msg",CustomizeErrorCode.PASSWORD_UNLIKE.getMassage());
            return "register";
        }
        User user = new User();
        user.setName(RegisterDTO.getName());
        user.setEmail(RegisterDTO.getEmail());
        user.setPhone(RegisterDTO.getPhone());
        user.setPassword(RegisterDTO.getPassword());
        user.setGmtModified(System.currentTimeMillis());
        user.setGmtCreate(user.getGmtModified());
        user.setAvatarUrl("/img/default.png");
        user.setLikeCount(0L);
        user.setFansCount(0L);
        user.setHot(0L);
        user.setPower(0);
        userMapper.insert(user);
        model.addAttribute("phone", RegisterDTO.getPhone());
        model.addAttribute("password", RegisterDTO.getPassword());
        model.addAttribute("msg","账户已成功注册！请登录！");
        return "login";
    }
}
