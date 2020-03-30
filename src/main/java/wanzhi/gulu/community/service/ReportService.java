package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.mapper.ReportDealMapper;
import wanzhi.gulu.community.mapper.ReportMapper;
import wanzhi.gulu.community.model.Report;
import wanzhi.gulu.community.model.ReportDeal;
import wanzhi.gulu.community.model.ReportDealExample;
import wanzhi.gulu.community.model.ReportExample;
import wanzhi.gulu.community.util.ReportUtils;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    ReportDealMapper reportDealMapper;

    @Autowired
    ReportUtils reportUtils;

    @Transactional
    public void createReport(Report report) {
        //1.创建举报表
        ReportExample example = new ReportExample();
        example.createCriteria()
                .andTargetIdEqualTo(report.getTargetId())
                .andTargetTypeEqualTo(report.getTargetType())
                .andReporterEqualTo(report.getReporter());
        List<Report> reports = reportMapper.selectByExample(example);
        if (reports.size()!=0){
            throw new CustomizeException(CustomizeErrorCode.HAS_REPORT);
        }
        reportMapper.insert(report);
        //2.创建或更新举报处理表
        CreateOrUpdateDeal(report.getTargetId(),report.getTargetType());
    }

    @Transactional
    private void CreateOrUpdateDeal(Long targetId, Integer targetType) {
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andTargetIdEqualTo(targetId)
                .andTargetTypeEqualTo(targetType);
        List<ReportDeal> reportDeals = reportDealMapper.selectByExample(example);
        if (reportDeals.size()==0){
            //创建deal表
            ReportDeal reportDeal = new ReportDeal();
            reportDeal.setTargetId(targetId);
            reportDeal.setTargetType(targetType);
            reportDeal.setReportCount(1L);
            reportDeal.setLatestCount(1L);
            reportDeal.setBanCount(0L);
            reportDeal.setStatus(1);
            reportDealMapper.insert(reportDeal);
        }else{
            ReportDeal reportDeal = reportDeals.get(0);
            //若是申诉通过再次被举报
            reportDeal.setStatus(1);
            ReportDealExample reportDealExample = new ReportDealExample();
            reportDealExample.createCriteria()
                    .andIdEqualTo(reportDeal.getId());
            reportDealMapper.updateByExampleSelective(reportDeal, reportDealExample);
            //更新deal表的举报数
            reportUtils.incDealReportCount(reportDeal.getId(),1L);
            reportUtils.incDealLatestCount(reportDeal.getId(),1L);
        }
    }
}
