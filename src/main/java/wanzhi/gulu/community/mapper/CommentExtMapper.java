package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.HotDTO;
import wanzhi.gulu.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment record);

    int incHot(HotDTO record);
}