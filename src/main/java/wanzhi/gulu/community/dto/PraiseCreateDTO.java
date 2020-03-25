package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class PraiseCreateDTO {
    private Long creator;
    private Long praiseId;
    private Integer type;
}
