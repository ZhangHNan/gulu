package wanzhi.gulu.community.dto;

import lombok.Data;

/**
 * 保存从github获取的信息（想要保存哪个信息就添加哪个属性，将这些属性抽取为JavaBean）
 */
@Data
public class GithubUser {
    private Long id;       //github的id
    private String login;  //返回的name为空的，login才是用户名
    private String name;   //github账号设置的名称
    private String bio;    //github的简介
    private String email;  //github上保存的email
    private String avatarUrl; //github头像
}
