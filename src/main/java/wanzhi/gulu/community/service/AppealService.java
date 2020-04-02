package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.AppealApplyDTO;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.mapper.AppealMapper;
import wanzhi.gulu.community.model.Appeal;
import wanzhi.gulu.community.model.AppealExample;
import wanzhi.gulu.community.util.PageUtils;

@Service
public class AppealService {

    @Autowired
    AppealMapper appealMapper;

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
    public void passAppeal(Long id) {
        Appeal appeal = appealMapper.selectByPrimaryKey(id);
        appeal.setStatus(0);
        AppealExample example = new AppealExample();
        example.createCriteria().andIdEqualTo(appeal.getId());
        appealMapper.updateByExample(appeal, example);
    }
}
