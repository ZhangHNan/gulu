package wanzhi.gulu.community.dto;

import java.time.LocalDateTime;

//手机验证码
public class SmsCode {
    private String code; //短信验证码验证码
    private LocalDateTime expireTime; //过期时间
    private String phone; //发送的手机号

    //构造函数：传入验证码谜底和多少秒后过期
    public SmsCode(String code, int expireAfterSeconds, String phone){
        this.code =code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireAfterSeconds);//过期时间=当前时间+传入的秒数
        this.phone = phone;
    }

    //判断验证码是否过期
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);//判断当前时间是否在过期时间之后
    }

    public String getCode() {
        return code;
    }

    public String getPhone() {
        return phone;
    }
}
