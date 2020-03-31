package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.mapper.AppealMapper;
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


    public PageDTO findMyAppealPageById(Integer currentPage, Long loginId) {
        return pageUtils.autoStructureMyAppealPageDTOByLoginId(currentPage, questionRows, questionButtonCount,loginId);
    }
}
