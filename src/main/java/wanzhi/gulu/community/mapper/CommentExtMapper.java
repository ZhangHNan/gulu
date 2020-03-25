package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.HotDTO;
import wanzhi.gulu.community.dto.PraiseDTO;
import wanzhi.gulu.community.model.Comment;

public interface CommentExtMapper {
    void incCommentCount(Comment record);

    void incHot(HotDTO record);

    void incPraise(PraiseDTO praiseDTO);

    void redPraise(PraiseDTO praiseDTO);
}