package wanzhi.gulu.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wanzhi.gulu.community.dto.ResultDTO;
import wanzhi.gulu.community.dto.SmsCode;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.UserService;
import wanzhi.gulu.community.sms.SendSmsService;
import wanzhi.gulu.community.sms.SmSTemplateType;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j //lombok集成的打印日志的
@RestController
public class SmsController {

    @Resource
    UserService userService;

    @Resource
    SendSmsService sendSmsService;

    @GetMapping("/smsCodeLogin")
    public ResultDTO smsLogin(@RequestParam String phone,
                            HttpSession session){
        //根据手机号查询用户
        User dbUser = userService.findUserByPhone(phone);
        if (dbUser==null){
            return ResultDTO.errorOf("您输入的手机号没有注册！");
        }

        //创建一个SmsCode对象，设置 生成的随机4位数（短信验证码）、60秒过期时间、手机号
        SmsCode smsCode = new SmsCode(
                RandomStringUtils.randomNumeric(4),60,phone
        );
        log.info(smsCode.getCode() + " -> " + phone);
        //TODO 模拟 调用短信服务提供商的接口发送短信
        boolean sendStatus = sendSmsService.sendSms(smsCode.getPhone(), SmSTemplateType.LOGIN, smsCode.getCode());
        if (sendStatus==false){
            return ResultDTO.okOf("出意外了，短信验证发送失败!");
        }
        //将谜底存入session
        session.setAttribute("sms_login_key",smsCode);
        return ResultDTO.okOf("短信验证码已经发送");

    }

    @GetMapping("/smsCodeRegister")
    public ResultDTO smsRegister(@RequestParam String phone,
                         HttpSession session){
        //验证手机号是否注册过
        User userByPhone = userService.findUserByPhone(phone);
        if (userByPhone!=null){
            return ResultDTO.errorOf("获取验证码失败！该手机号已经注册过了！");
        }
        //创建一个SmsCode对象，设置 生成的随机4位数（短信验证码）、60秒过期时间、手机号
        SmsCode smsCode = new SmsCode(
                RandomStringUtils.randomNumeric(4),60,phone
        );
        log.info(smsCode.getCode() + " -> " + phone);
        //如果发送失败可以根据短信验证码返回JSON的message不是ok
        if (phone.length()!=11){
            return ResultDTO.errorOf("手机号不正确，获取验证码失败！");
        }
        //TODO 模拟 调用短信服务提供商的接口发送短信
        boolean sendStatus = sendSmsService.sendSms(smsCode.getPhone(), SmSTemplateType.REGISTER, smsCode.getCode());
        if (sendStatus==false){
            return ResultDTO.okOf("出意外了，短信验证发送失败!");
        }
        //将谜底存入session
        session.setAttribute("sms_register_key",smsCode);
        return ResultDTO.okOf("短信验证码已经发送");
    }
}
