package wanzhi.gulu.community.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import wanzhi.gulu.community.dto.SmsResponse;

//发送短信验证码服务
@Service
@PropertySource(value = {"classpath:aliyun.properties"})
public class SendSmsService {

    @Value("${sms.aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${sms.aliyun.accessKeySecret}")
    private String accessKeySecret;

    //传入要发送的手机号和验证码即可(返回true表示发送成功，返回false表示发送失败)
    public boolean sendSms(String receive,SmSTemplateType templateType,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("SignName", "GULUWANG");
        request.putQueryParameter("TemplateCode", templateType.getTemplateCode());
        //接受验证码的手机号
        request.putQueryParameter("PhoneNumbers", receive);
        //模板参数（具体的验证码）【注意：要使用JSON格式】
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");

        try {
            //发送短信验证码并接受返回数据（JSON）
            CommonResponse response = client.getCommonResponse(request);
            SmsResponse smsResponse = JSON.parseObject(response.getData(), SmsResponse.class);
            System.out.println(response.getData());
            System.out.println(smsResponse);
            if (smsResponse.getMessage().equals("OK")&&smsResponse.getCode().equals("OK")){
                return true;
            }
            //如果发送成功返回true（短信验证码发送成功）;发送失败返回false；（出意外了，短信验证发送失败）
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
