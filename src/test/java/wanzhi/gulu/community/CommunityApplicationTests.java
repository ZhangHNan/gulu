package wanzhi.gulu.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wanzhi.gulu.community.sms.SendSmsService;
import wanzhi.gulu.community.sms.SmSTemplateType;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Resource
    SendSmsService sendSmsService;

    @Test
    public void contextLoads() {
        boolean sendStatus = sendSmsService.sendSms("1821919876", SmSTemplateType.LOGIN, "6666");
        if (sendStatus==true){
            System.out.println("短信验证码发送成功");
        }else{
            System.out.println("出意外了，短信验证发送失败!");
        }
    }

}
