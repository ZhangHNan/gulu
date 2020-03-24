package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import wanzhi.gulu.community.dto.registerDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
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

    @PostMapping("/register")
    public String register(registerDTO registerDTO,
                           Model model){
        //验证手机号是否注册过
        UserExample example = new UserExample();
        example.createCriteria()
                .andPhoneEqualTo(registerDTO.getPhone());
        List<User> users = userMapper.selectByExample(example);
        if(users.size()!=0){
            //回显并携带错误信息
            model.addAttribute("phone",registerDTO.getPhone());
            model.addAttribute("name",registerDTO.getName());
            model.addAttribute("email",registerDTO.getEmail());
            model.addAttribute("password",registerDTO.getPassword());
            model.addAttribute("passwordAgain",registerDTO.getPasswordAgain());
            model.addAttribute("msg",CustomizeErrorCode.PHONE_ALREADY_EXIST.getMassage());
            return "register";
        }
        //手机验证码通过后才执行下面语句

        //验证输入密码与再次输入密码是否一致
        if (!registerDTO.getPassword().equals(registerDTO.getPasswordAgain())){
            //回显并携带错误信息
            model.addAttribute("phone",registerDTO.getPhone());
            model.addAttribute("name",registerDTO.getName());
            model.addAttribute("email",registerDTO.getEmail());
            model.addAttribute("password",registerDTO.getPassword());
            model.addAttribute("passwordAgain",registerDTO.getPasswordAgain());
            model.addAttribute("msg",CustomizeErrorCode.PASSWORD_UNLIKE.getMassage());
            return "register";
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPhone(registerDTO.getPhone());
        user.setPassword(registerDTO.getPassword());
        user.setGmtModified(System.currentTimeMillis());
        user.setGmtCreate(user.getGmtModified());
        user.setLikeCount(0L);
        user.setFansCount(0L);
        user.setHot(0L);
        user.setPower(0);
        userMapper.insert(user);
        model.addAttribute("phone",registerDTO.getPhone());
        model.addAttribute("password",registerDTO.getPassword());
        return "login";
    }
}
