package wanzhi.gulu.community.dto;

import lombok.Data;

//踩DTO
@Data
public class TreadCreateDTO {
    private Long creator;
    private Long treadId;
    private Integer type;
}
