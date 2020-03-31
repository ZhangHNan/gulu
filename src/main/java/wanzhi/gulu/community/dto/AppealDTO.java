package wanzhi.gulu.community.dto;

import lombok.Data;
import wanzhi.gulu.community.model.ReportDeal;

@Data
public class AppealDTO {
    private Long id;
    private Long dealId;
    private String appealReason;
    private Long gmtCreate;
    private Integer status;
    private ReportDeal deal; //需要其中的targetId、reportCount、banCount、dealResult
}
