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
        sendSmsService.sendSms("18219198767",SmSTemplateType.LOGIN,"1234");

    }

}
