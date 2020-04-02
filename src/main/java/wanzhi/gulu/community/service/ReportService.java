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
    NotificationMapper notificationMapper;

    @Autowired
    ReportUtils reportUtils;

    @Autowired
    PageUtils pageUtils;

    @Value("${page.question.rows}")
    private Integer questionRows;//设置我的问题页每页展示数据行数

    @Value("${page.question.buttonCount}")
    private Integer questionButtonCount;//设置我的问题页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个

    //举报功能：创建举报表、创建或更新举报处理表
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

    //创建或更新举报处理表
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

    //举报不通过：驳回举报
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

    //举报通过：封禁待申诉：只有帖子可以申诉
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

    /**
     * 永久封禁：帖子前两次封禁、评论封禁
     * @param id 需要永久封禁的reportDeal的id
     * @param type 即处理举报的类型：1帖子，2评论
     */
    @Transactional
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
            //这里还应该判断是一级评论还是二级评论，一级评论删除，还要删除其中的二级评论，二级评论直接删除即可
//            commentMapper.deleteByPrimaryKey(reportDeal.getTargetId());
            Comment comment = commentMapper.selectByPrimaryKey(reportDeal.getTargetId());
            if (comment.getType()==1){
                //评论帖子的
                CommentExample commentExample = new CommentExample();
                commentExample.createCriteria()
                        .andTargetIdEqualTo(comment.getId())
                        .andTypeEqualTo(2);
                List<Comment> comments = commentMapper.selectByExample(commentExample);
                for (Comment c:comments){
                    commentMapper.deleteByPrimaryKey(c.getId());
                    //删除通知
                    NotificationExample notificationExample = new NotificationExample();
                    notificationExample.createCriteria()
                            .andSourceIdEqualTo(c.getId())
                            .andTypeEqualTo(2);
                    notificationMapper.deleteByExample(notificationExample);
                }
                commentMapper.deleteByPrimaryKey(comment.getId());
                //删除通知
                NotificationExample notificationExample = new NotificationExample();
                notificationExample.createCriteria()
                        .andSourceIdEqualTo(comment.getId())
                        .andTypeEqualTo(1);
                notificationMapper.deleteByExample(notificationExample);
            }else{
                //评论评论的
                commentMapper.deleteByPrimaryKey(reportDeal.getTargetId());
                //删除通知
                NotificationExample notificationExample = new NotificationExample();
                notificationExample.createCriteria()
                        .andSourceIdEqualTo(reportDeal.getTargetId())
                        .andTypeEqualTo(2);
                notificationMapper.deleteByExample(notificationExample);
            }

        }else{
            //帖子 //永久删除 帖子 及其对应的一级评论和二级评论
            questionMapper.deleteByPrimaryKey(reportDeal.getTargetId());
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria()
                    .andTargetIdEqualTo(reportDeal.getTargetId())
                    .andTypeEqualTo(1);
            List<Comment> comments = commentMapper.selectByExample(commentExample);
            for(Comment com:comments){
                CommentExample comment2Example = new CommentExample();
                comment2Example.createCriteria()
                        .andTargetIdEqualTo(com.getId())
                        .andTypeEqualTo(2);
                List<Comment> comments2 = commentMapper.selectByExample(comment2Example);
                if (comments2.size()!=0){
                    for (Comment c: comments2){
                        commentMapper.deleteByPrimaryKey(c.getId());
                        //删除通知
                        NotificationExample notificationExample = new NotificationExample();
                        notificationExample.createCriteria()
                                .andSourceIdEqualTo(c.getId())
                                .andTypeEqualTo(2);
                        notificationMapper.deleteByExample(notificationExample);
                    }
                }
                commentMapper.deleteByPrimaryKey(com.getId());
                //删除通知
                NotificationExample notificationExample = new NotificationExample();
                notificationExample.createCriteria()
                        .andSourceIdEqualTo(com.getId())
                        .andTypeEqualTo(1);
                notificationMapper.deleteByExample(notificationExample);
            }
        }
    }

    //通过申诉后，reportDealMapper的处理逻辑
    public void passAppeal(Long appealId) {
        Appeal appeal = appealMapper.selectByPrimaryKey(appealId);
        ReportDeal reportDeal = reportDealMapper.selectByPrimaryKey(appeal.getDealId());
        reportDeal.setLatestCount(0L);
        reportDeal.setStatus(0);
        reportDeal.setGmtDeal(System.currentTimeMillis());
        reportDeal.setDealResult("申诉成功");
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andIdEqualTo(reportDeal.getId());
        reportDealMapper.updateByExample(reportDeal, example);
    }

    //用于查询需要处理的投诉处理申请数放入session域中
    public Integer findDealApplyCount() {
        ReportDealExample example = new ReportDealExample();
        example.createCriteria()
                .andStatusEqualTo(1);
        return reportDealMapper.countByExample(example);
    }
}
