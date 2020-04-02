package wanzhi.gulu.community.dto;

import lombok.Data;

//创建封禁DTO
@Data
public class BanCreateDTO {
    private Long id;
    private Long banCount;
    private Integer type;
    private String reportResult;
}
