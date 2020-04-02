package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.ReportDealExtMapper;
import wanzhi.gulu.community.mapper.ReportDealMapper;
import wanzhi.gulu.community.mapper.ReportMapper;

//举报工具类
@Component
public class ReportUtils {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    ReportDealExtMapper reportDealExtMapper;

    public void incDealReportCount(Long id, Long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        reportDealExtMapper.incReportCount(countDTO);
    }

    public void incDealLatestCount(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        reportDealExtMapper.incLatestCount(countDTO);
    }

    public void incDealBanCount(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        reportDealExtMapper.incBanCount(countDTO);
    }
}
