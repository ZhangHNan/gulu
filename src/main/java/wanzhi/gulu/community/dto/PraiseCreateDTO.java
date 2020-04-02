package wanzhi.gulu.community.dto;

import lombok.Data;

//创建点赞的DTO
@Data
public class PraiseCreateDTO {
    private Long creator;
    private Long praiseId;
    private Integer type;
}
