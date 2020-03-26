package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.*;
import wanzhi.gulu.community.model.*;

import java.util.List;

@Component
public class TreadUtils {

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    TreadMapper treadMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    public Integer getStatus(Long id,Long creatorId,Integer type){
        TreadExample example = new TreadExample();
        example.createCriteria()
                .andCreatorEqualTo(creatorId)
                .andTreadIdEqualTo(id)
                .andTypeEqualTo(type);
        List<Tread> treads = treadMapper.selectByExample(example);
        if (treads.size()==0){
            return 0; //当前用户没踩
        }else{
            return 1; //当前用户踩了
        }
    }

    public Long getQueTreCount(Long id){
        Question question = questionMapper.selectByPrimaryKey(id);
        return question.getTreadCount();
    }

    public void incQuestionTread(Long id, Long incCount){
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        questionExtMapper.incTread(countDTO);
    }

    public void redQuestionTread(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        questionExtMapper.redTread(countDTO);
    }

    public void incCommentTread(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        commentExtMapper.incTread(countDTO);
    }

    public void redCommentTread(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        commentExtMapper.redTread(countDTO);
    }

    public Long getComTreCount(Long id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment.getTreadCount();
    }
}
