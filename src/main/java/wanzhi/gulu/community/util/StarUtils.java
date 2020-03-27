package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.QuestionExtMapper;
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.mapper.StarMapper;
import wanzhi.gulu.community.mapper.UserExtMapper;
import wanzhi.gulu.community.model.Question;
import wanzhi.gulu.community.model.Star;
import wanzhi.gulu.community.model.StarExample;

import java.util.List;

@Component
public class StarUtils {

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    StarMapper starMapper;

    @Autowired
    UserExtMapper userExtMapper;

    public void incStar(Long id, Long incCount){
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        questionExtMapper.incStar(countDTO);
    }

    public void redStar(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        questionExtMapper.redStar(countDTO);
    }

    public Long getStarCount(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        return question.getStarCount();
    }

    public Integer getStatus(Long id, Long loginId) {
        StarExample example = new StarExample();
        example.createCriteria()
                .andCollectorEqualTo(loginId)
                .andStarIdEqualTo(id);
        List<Star> stars = starMapper.selectByExample(example);
        if(stars.size()== 0){
            return 0; //当前用户没收藏
        }
        return 1; //当前用户收藏了
    }

    public void incFans(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        userExtMapper.incFans(countDTO);
    }

    public void redFans(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        userExtMapper.redFans(countDTO);
    }
}
