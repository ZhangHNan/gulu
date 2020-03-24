package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class registerDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String passwordAgain;
}
