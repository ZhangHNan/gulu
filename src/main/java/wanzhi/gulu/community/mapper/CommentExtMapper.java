package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.model.Comment;

public interface CommentExtMapper {
    void incCommentCount(Comment record);

    void incHot(CountDTO record);

    void incPraise(CountDTO countDTO);

    void redPraise(CountDTO countDTO);

    void incTread(CountDTO countDTO);

    void redTread(CountDTO countDTO);
}