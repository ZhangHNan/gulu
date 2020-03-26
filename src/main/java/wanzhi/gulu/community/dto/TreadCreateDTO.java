package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class TreadCreateDTO {
    private Long creator;
    private Long treadId;
    private Integer type;
}
