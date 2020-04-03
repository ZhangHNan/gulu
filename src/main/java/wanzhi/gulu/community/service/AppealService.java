package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.AppealApplyDTO;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.enums.NotificationStatusEnum;
import wanzhi.gulu.community.enums.NotificationTypeEnum;
import wanzhi.gulu.community.mapper.AppealMapper;
import wanzhi.gulu.community.mapper.NotificationMapper;
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.model.Appeal;
import wanzhi.gulu.community.model.AppealExample;
import wanzhi.gulu.community.model.Notification;
import wanzhi.gulu.community.model.Question;
import wanzhi.gulu.community.util.PageUtils;

@Service
public class AppealService {

    @Autowired
    AppealMapper appealMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    PageUtils pageUtils;

    @Value("${page.question.rows}")
    private Integer questionRows;//设置我的问题页每页展示数据行数

    @Value("${page.question.buttonCount}")
    private Integer questionButtonCount;//设置我的问题页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个

    //申诉中心提交申诉后：创建申诉状态数据
    @Transactional
    public void createApply(AppealApplyDTO appealApplyDTO) {
        Appeal appeal = appealMapper.selectByPrimaryKey(appealApplyDTO.getId());
        appeal.setStatus(2);
        appeal.setAppealReason(appealApplyDTO.getAppealReason());
        AppealExample example = new AppealExample();
        example.createCriteria().andIdEqualTo(appeal.getId());
        appealMapper.updateByExample(appeal, example);
    }

    public PageDTO findMyAppealPageById(Integer currentPage, Long loginId) {
        return pageUtils.autoStructureMyAppealPageDTOByLoginId(currentPage, questionRows, questionButtonCount,loginId);
    }

    //检查这个申诉是不是本人的
    public Boolean check(long id, long loginId){
        Appeal appeal = appealMapper.selectByPrimaryKey(id);
        return appeal.getUserId() == loginId;
    }

    //处理用户提交的申诉：申诉不通过
    @Transactional
    public Long outAppeal(Long id) {
        Appeal appeal = appealMapper.selectByPrimaryKey(id);
        appeal.setStatus(3);
        AppealExample example = new AppealExample();
        example.createCriteria().andIdEqualTo(appeal.getId());
        appealMapper.updateByExample(appeal, example);
        return appeal.getDealId();
    }

    public PageDTO findAppealDealPage(Integer currentPage) {
        return pageUtils.autoStructureAppealDealPageDTOByStatus(currentPage, questionRows, questionButtonCount);
    }

    //处理用户提交的申诉：申诉通过
    @Transactional
    public void passAppeal(Long id) {
        Appeal appeal = appealMapper.selectByPrimaryKey(id);
        //创建通知
        createPassNotify(appeal);
        appeal.setStatus(0);
        AppealExample example = new AppealExample();
        example.createCriteria().andIdEqualTo(appeal.getId());
        appealMapper.updateByExample(appeal, example);
    }

    //创建封禁通知：传入被Watch对象即可
    private void createPassNotify(Appeal appeal) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(NotificationTypeEnum.APPEAL_SUCCESS.getType());
        notification.setTypeName(NotificationTypeEnum.APPEAL_SUCCESS.getName());
        notification.setReceiver(appeal.getUserId());
        notification.setOuterId(appeal.getQuestionId());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        Question targetQuestion = questionMapper.selectByPrimaryKey(appeal.getQuestionId());
        if (targetQuestion.getTitle().length()>10){
            String substring = targetQuestion.getTitle().substring(0, 9);
            String titleShort = substring + "...";
            notification.setOuterTitle(titleShort);
        }else{
            notification.setOuterTitle(targetQuestion.getTitle());
        }
        notificationMapper.insert(notification);
    }

    //用于查询我被封禁待申诉数放入session域中
    public Integer findMyAppealCount(Long id) {
        AppealExample example = new AppealExample();
        example.createCriteria()
                .andUserIdEqualTo(id)
                .andStatusEqualTo(1);
        return appealMapper.countByExample(example);
    }

    //用于查询需要处理的申诉申请数放入session域中
    public Integer findAppealApplyCount() {
        AppealExample example = new AppealExample();
        example.createCriteria()
                .andStatusEqualTo(2);
        return appealMapper.countByExample(example);
    }
}
