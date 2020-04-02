package wanzhi.gulu.community.dto;

import lombok.Data;

//注册用的DTO
@Data
public class RegisterDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String passwordAgain;
}
