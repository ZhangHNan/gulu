package wanzhi.gulu.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.mapper.UserMapper;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.model.UserExample;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    //手机号登录功能：手机号+密码 方式登录
    @PostMapping("/login")
    public String login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletResponse response){
        //短信验证

        //输入校验
        if (StringUtils.isBlank(phone)){
            model.addAttribute("phone",phone);
            model.addAttribute("password",password);
            model.addAttribute("msg","手机号不能为空！");
            return "login";
        }
        if (StringUtils.isBlank(password)){
            model.addAttribute("phone",phone);
            model.addAttribute("password",password);
            model.addAttribute("msg","密码不能为空！");
            return "login";
        }
        UserExample example = new UserExample();
        example.createCriteria()
                .andPhoneEqualTo(phone)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size()!=0){
            //登录逻辑
            User user = users.get(0);
            String token = UUID.randomUUID().toString();//抽取token用于存入cookie
            user.setToken(token);
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(user.getId());
            userMapper.updateByExampleSelective(user,userExample);
            response.addCookie(new Cookie("token",token));
        }else{
            model.addAttribute("phone",phone);
            model.addAttribute("password",password);
            model.addAttribute("msg","密码错误！请重新输入密码，或检查账户是否正确！");
            return "login";
        }
        return "redirect:/index";
    }
}
