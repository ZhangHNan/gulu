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
    private String titleShort;    //如果标题或评论的长度大于10：标题前10个字或评论前10个字+。。。小于10直接全部显示
}
