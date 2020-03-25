package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.HotDTO;
import wanzhi.gulu.community.mapper.CommentExtMapper;
import wanzhi.gulu.community.mapper.QuestionExtMapper;
import wanzhi.gulu.community.mapper.UserExtMapper;

@Component
public class HotUtils {

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    UserExtMapper userExtMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    public void incQuestionHot(Long id,Long incCount){
        HotDTO hotDTO = new HotDTO();
        hotDTO.setId(id);
        hotDTO.setIncHotCount(incCount);
        questionExtMapper.incHot(hotDTO);
    }

    public void incUserHot(Long id,Long incCount){
        HotDTO hotDTO = new HotDTO();
        hotDTO.setId(id);
        hotDTO.setIncHotCount(incCount);
        userExtMapper.incHot(hotDTO);
    }

    public void incCommentHot(Long id,Long incCount){
        HotDTO hotDTO = new HotDTO();
        hotDTO.setId(id);
        hotDTO.setIncHotCount(incCount);
        commentExtMapper.incHot(hotDTO);
    }
}
