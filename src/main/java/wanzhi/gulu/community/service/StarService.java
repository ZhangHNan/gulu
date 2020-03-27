package wanzhi.gulu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wanzhi.gulu.community.dto.StarCreateDTO;
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.mapper.StarMapper;
import wanzhi.gulu.community.model.Question;
import wanzhi.gulu.community.model.Star;
import wanzhi.gulu.community.model.StarExample;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.StarUtils;

import java.util.List;

@Service
public class StarService {

    @Autowired
    StarMapper starMapper;

    @Autowired
    HotUtils hotUtils;

    @Autowired
    StarUtils starUtils;

    @Autowired
    QuestionMapper questionMapper;

    public Star checkStarStatus(StarCreateDTO starCreateDTO) {
        StarExample example = new StarExample();
        example.createCriteria()
                .andCollectorEqualTo(starCreateDTO.getCollector())
                .andStarIdEqualTo(starCreateDTO.getStarId());
        List<Star> stars = starMapper.selectByExample(example);
        if (stars.size()!=0){
            return stars.get(0);
        }
        return null;
    }

    public Long createStar(StarCreateDTO starCreateDTO) {
        Star star = new Star();
        star.setGmtCreate(System.currentTimeMillis());
        BeanUtils.copyProperties(starCreateDTO,star);
        //创建数据
        starMapper.insert(star);
        //增加问题的star_count
        starUtils.incStar(starCreateDTO.getStarId(),1L);
        //热度值
        hotUtils.incQuestionHot(starCreateDTO.getStarId(),5L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(starCreateDTO.getStarId());
        hotUtils.incUserHot(targetQuestion.getCreator(),5L);
        //返回收藏数
        return starUtils.getStarCount(starCreateDTO.getStarId());
    }

    public Long removeStar(Star star) {
        starMapper.deleteByPrimaryKey(star.getId());
        starUtils.redStar(star.getStarId(),1L);
        //热度值
        hotUtils.redQuestionHot(star.getStarId(),5L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(star.getStarId());
        hotUtils.redUserHot(targetQuestion.getCreator(),5L);
        return starUtils.getStarCount(star.getStarId());
    }
}