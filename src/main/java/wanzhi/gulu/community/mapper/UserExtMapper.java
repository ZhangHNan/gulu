package wanzhi.gulu.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.dto.HotDTO;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.model.UserExample;

import java.util.List;

public interface UserExtMapper {
    int incHot(HotDTO record);
}