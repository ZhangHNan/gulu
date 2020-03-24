package wanzhi.gulu.community.dto;

import lombok.Data;
import wanzhi.gulu.community.model.User;

//DTO类似信使，是同步系统中的Message。一个DTO包含的信息是完整的。
@Data
public class QuestionDTO {
    private Long id;
    private String title;       //问题标题
    private String description; //问题详情
    private String tag;         //标签
    private Long creator;       //创建人
    private Long viewCount;    //浏览量
    private Long likeCount;    //点赞数
    private Long treadCount;  //被踩数
    private Long hot;   //热度值
    private Long commentCount; //问题的一级评论数
    private Long gmtCreate;     //创建时间
    private Long gmtModified;   //修改时间
    private User user;          //创建人详情
}
