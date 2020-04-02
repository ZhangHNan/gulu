package wanzhi.gulu.community.dto;

import lombok.Data;
import wanzhi.gulu.community.model.Report;

import java.util.List;

//创建投诉管理表数据需要的DTO
@Data
public class ReportDealDTO {
    private Long id;
    private Long targetId;
    private Integer targetType;
    private Long reportCount;
    private Long latestCount;
    private Long banCount;
    private String titleShort;    //如果标题或评论的长度大于10：标题前10个字或评论前10个字+。。。小于10直接全部显示
    private String title;         //问题题目，评论不用
    private String content;       //评论的内容，问题不用
    private List<Report> reports; //具体的举报报表
}
