package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;

public interface UserExtMapper {
    void incHot(CountDTO record);

    void redHot(CountDTO hotDTO);
}