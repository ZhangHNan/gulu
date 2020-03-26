package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.*;
import wanzhi.gulu.community.model.Comment;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.PraiseExample;
import wanzhi.gulu.community.model.Question;

import java.util.List;

@Component
public class PraiseUtils {

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    PraiseMapper praiseMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    public Integer getStatus(Long praiseId,Long creatorId,Integer type){
        PraiseExample example = new PraiseExample();
        example.createCriteria()
                .andCreatorEqualTo(creatorId)
                .andPraiseIdEqualTo(praiseId)
                .andTypeEqualTo(type);
        List<Praise> praises = praiseMapper.selectByExample(example);
        if (praises.size()==0){
            return 0; //当前用户没点赞
        }else{
            return 1; //当前用户点赞了
        }
    }

    public Long getQuePraCount(Long id){
        Question question = questionMapper.selectByPrimaryKey(id);
        return question.getPraiseCount();
    }

    public void incQuestionPraise(Long id, Long incCount){
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        questionExtMapper.incPraise(countDTO);
    }

    public void redQuestionPraise(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        questionExtMapper.redPraise(countDTO);
    }

    public void incCommentPraise(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        commentExtMapper.incPraise(countDTO);
    }

    public void redCommentPraise(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        commentExtMapper.redPraise(countDTO);
    }

    public Long getComPraCount(Long id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment.getPraiseCount();
    }
}
