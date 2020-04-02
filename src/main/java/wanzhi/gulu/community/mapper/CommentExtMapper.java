package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.model.Comment;

//评论扩展mapper接口
public interface CommentExtMapper {

    //增加评论数
    void incCommentCount(Comment record);

    //增加热度值
    void incHot(CountDTO record);

    //减少热度值
    void redHot(CountDTO hotDTO);

    //增加点赞数
    void incPraise(CountDTO countDTO);

    //减少点赞数
    void redPraise(CountDTO countDTO);

    //增加踩数
    void incTread(CountDTO countDTO);

    //减少踩数
    void redTread(CountDTO countDTO);
}