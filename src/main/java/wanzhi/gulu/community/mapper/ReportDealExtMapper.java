package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;

public interface ReportDealExtMapper {
    void incReportCount(CountDTO countDTO);

    void redReportCount(CountDTO countDTO);

    void incLatestCount(CountDTO countDTO);

    void redLatestCount(CountDTO countDTO);

    void incBanCount(CountDTO countDTO);

    void redBanCount(CountDTO countDTO);
}