package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;

public interface UserExtMapper {

    void incHot(CountDTO record);

    void redHot(CountDTO hotDTO);

    void incPraise(CountDTO countDTO);

    void redPraise(CountDTO countDTO);

    //增加粉丝数
    void incFans(CountDTO countDTO);

    //减少粉丝数
    void redFans(CountDTO countDTO);
}