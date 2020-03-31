package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.mapper.*;
import wanzhi.gulu.community.model.*;
import wanzhi.gulu.community.util.PageUtils;
import wanzhi.gulu.community.util.ReportUtils;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    ReportDealMapper reportDealMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    AppealMapper appealMapper;

    @Autowired
    ReportUtils reportUtils;

    @Autowired
    PageUtils pageUtils;

    @Value("${page.question.rows}")
    private Integer questionRows;//设置我的问题页每页展示数据行数

    @Value("${page.question.buttonCount}")
    private Integer questionButtonCount;//设置我的问题页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个


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
    void CreateOrUpdateDeal(Long targetId, Integer targetType) {
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

    public PageDTO findDealPage(Integer currentPage) {
        return pageUtils.autoStructureDealPageDTO(currentPage,questionRows,questionButtonCount);
    }

    public void cancelReport(Long id) {
        //驳回 :举报不成功 latest_count 清零，status置0，设置处理时间，设置处理结果：驳回
        ReportDeal reportDeal = reportDealMapper.selectByPrimaryKey(id);
        reportDeal.setLatestCount(0L);
        reportDeal.setStatus(0);
        reportDeal.setGmtDeal(System.currentTimeMillis());
        reportDeal.setDealResult("驳回");
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andIdEqualTo(id);
        reportDealMapper.updateByExample(reportDeal, example);
    }

    //封禁待申诉：只有帖子可以申诉
    @Transactional
    public void ban(Long id,String reportResult) {
        //封禁 :举报成功，latest_count清零，status置2，增加处理时间，处理结果。banCount+1，问题设置为ban状态，创建申诉表
        ReportDeal reportDeal = reportDealMapper.selectByPrimaryKey(id);
        reportDeal.setLatestCount(0L);
        reportDeal.setStatus(2);
        reportDeal.setGmtDeal(System.currentTimeMillis());
        reportDeal.setDealResult(reportResult);
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andIdEqualTo(id);
        reportDealMapper.updateByExample(reportDeal, example);
        reportUtils.incDealBanCount(id,1L);
        Question question = questionMapper.selectByPrimaryKey(reportDeal.getTargetId());
        question.setBan(1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(question.getId());
        questionMapper.updateByExample(question, questionExample);
        //创建申诉表
        Appeal appeal = new Appeal();
        appeal.setDealId(id);
        appeal.setQuestionId(question.getId());
        appeal.setUserId(question.getCreator());
        appeal.setGmtCreate(System.currentTimeMillis());
        appeal.setStatus(1);
        appealMapper.insert(appeal);
    }

    public void foreverBan(Long id, Integer type) {
        //banCount=2 永久删除 status=4 || 评论 删除 status=4 处理结果设置为永久封禁
        ReportDeal reportDeal = reportDealMapper.selectByPrimaryKey(id);
        reportDeal.setLatestCount(0L);
        reportDeal.setStatus(4);
        reportDeal.setGmtDeal(System.currentTimeMillis());
        reportDeal.setDealResult("永久删除");
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andIdEqualTo(id);
        reportDealMapper.updateByExample(reportDeal, example);
        if (type==2){
            //评论
            //删除
            //删除评论，评论对应的帖子的评论数理应减少，但太麻烦了，这里只作评论删除即可
            commentMapper.deleteByPrimaryKey(reportDeal.getTargetId());
        }else{
            //帖子 //永久删除 帖子 及其对应的一级评论和二级评论
            questionMapper.deleteByPrimaryKey(reportDeal.getTargetId());
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria()
                    .andTargetIdEqualTo(reportDeal.getTargetId())
                    .andTypeEqualTo(1);
            List<Comment> comments = commentMapper.selectByExample(commentExample);
            for(Comment c:comments){
                CommentExample comment2Example = new CommentExample();
                comment2Example.createCriteria()
                        .andTargetIdEqualTo(c.getId())
                        .andTypeEqualTo(2);
                List<Comment> comments2 = commentMapper.selectByExample(comment2Example);
                if (comments2.size()!=0){
                    for (Comment com: comments2){
                        commentMapper.deleteByPrimaryKey(com.getId());
                    }
                }
                commentMapper.deleteByPrimaryKey(c.getId());
            }
        }
    }
}
