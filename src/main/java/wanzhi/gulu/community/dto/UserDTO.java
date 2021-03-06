package wanzhi.gulu.community.dto;

import lombok.Data;

//用于用户信息展示
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String avatarUrl;
    private String bio;
    private Long likeCount;
    private Long fansCount;
    private Long hot;
    private Integer power;
    private Boolean watch; //是否关注了这个用户
}
