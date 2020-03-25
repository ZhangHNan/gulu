package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.PraiseDTO;
import wanzhi.gulu.community.mapper.CommentExtMapper;
import wanzhi.gulu.community.mapper.QuestionExtMapper;

@Component
public class PraiseUtils {

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    public void incQuestionPraise(Long id, Long incCount){
        PraiseDTO praiseDTO = new PraiseDTO();
        praiseDTO.setId(id);
        praiseDTO.setPraiseCount(incCount);
        questionExtMapper.incPraise(praiseDTO);
    }

    public void redQuestionPraise(Long id, long redCount) {
        PraiseDTO praiseDTO = new PraiseDTO();
        praiseDTO.setId(id);
        praiseDTO.setPraiseCount(redCount);
        questionExtMapper.redPraise(praiseDTO);
    }

    public void incCommentPraise(Long id, long incCount) {
        PraiseDTO praiseDTO = new PraiseDTO();
        praiseDTO.setId(id);
        praiseDTO.setPraiseCount(incCount);
        commentExtMapper.incPraise(praiseDTO);
    }

    public void redCommentPraise(Long id, long redCount) {
        PraiseDTO praiseDTO = new PraiseDTO();
        praiseDTO.setId(id);
        praiseDTO.setPraiseCount(redCount);
        commentExtMapper.redPraise(praiseDTO);
    }
}
