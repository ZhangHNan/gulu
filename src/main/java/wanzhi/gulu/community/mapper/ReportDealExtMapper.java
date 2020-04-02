package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;

public interface ReportDealExtMapper {

    //增加被举报数
    void incReportCount(CountDTO countDTO);

    void redReportCount(CountDTO countDTO);

    //增加最近举报数（即最近一次解封后受到的举报数）
    void incLatestCount(CountDTO countDTO);

    void redLatestCount(CountDTO countDTO);

    //增加封禁数
    void incBanCount(CountDTO countDTO);

    void redBanCount(CountDTO countDTO);
}