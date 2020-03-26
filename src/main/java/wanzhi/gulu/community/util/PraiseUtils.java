package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.PraiseDTO;
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

    public Long getComPraCount(Long id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment.getPraiseCount();
    }
}
