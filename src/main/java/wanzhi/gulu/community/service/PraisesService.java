package wanzhi.gulu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.PraiseCreateDTO;
import wanzhi.gulu.community.mapper.PraiseMapper;
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.PraiseExample;
import wanzhi.gulu.community.model.Question;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.PraiseUtils;

import java.util.List;

@Service
public class PraisesService {

    @Autowired
    PraiseMapper praiseMapper;

    @Autowired
    PraiseUtils praiseUtils;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    HotUtils hotUtils;

    public Praise checkPraiseStatus(PraiseCreateDTO praiseCreateDTO) {
        PraiseExample example = new PraiseExample();
        example.createCriteria()
                .andCreatorEqualTo(praiseCreateDTO.getCreator())
                .andPraiseIdEqualTo(praiseCreateDTO.getPraiseId())
                .andTypeEqualTo(praiseCreateDTO.getType());
        List<Praise> praises = praiseMapper.selectByExample(example);
        if (praises.size()!=0){
            return praises.get(0);
        }
        return null;
    }

    @Transactional
    public Long createQuestionPraise(PraiseCreateDTO praiseCreateDTO) {
        Praise praise = new Praise();
        praise.setGmtCreate(System.currentTimeMillis());
        BeanUtils.copyProperties(praiseCreateDTO,praise);
        //创建like数据
        praiseMapper.insert(praise);
        //增加问题likeCount
        praiseUtils.incQuestionPraise(praiseCreateDTO.getPraiseId(),1L);
        //热度值
        hotUtils.incQuestionHot(praiseCreateDTO.getPraiseId(),3L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(praiseCreateDTO.getPraiseId());
        hotUtils.incUserHot(targetQuestion.getCreator(),3L);
        //返回点赞数
        return praiseUtils.getQuePraCount(praiseCreateDTO.getPraiseId());

    }

    @Transactional
    public Long removeQuestionPraise(Praise praise){
        praiseMapper.deleteByPrimaryKey(praise.getId());
        praiseUtils.redQuestionPraise(praise.getPraiseId(),1L);
        //热度值
        hotUtils.redQuestionHot(praise.getPraiseId(),3L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(praise.getPraiseId());
        hotUtils.redUserHot(targetQuestion.getCreator(),3L);
        return praiseUtils.getQuePraCount(praise.getPraiseId());
    }

    @Transactional
    public Long createCommentPraise(PraiseCreateDTO praiseCreateDTO) {
        Praise praise = new Praise();
        praise.setGmtCreate(System.currentTimeMillis());
        BeanUtils.copyProperties(praiseCreateDTO,praise);
        //创建like数据
        praiseMapper.insert(praise);
        //增加评论likeCount
        praiseUtils.incCommentPraise(praiseCreateDTO.getPraiseId(),1L);
        //热度值
        hotUtils.incCommentHot(praiseCreateDTO.getPraiseId(),3L);
        //返回点赞数
        return praiseUtils.getComPraCount(praiseCreateDTO.getPraiseId());
    }

    @Transactional
    public Long removeCommentPraise(Praise praise) {
        praiseMapper.deleteByPrimaryKey(praise.getId());
        praiseUtils.redCommentPraise(praise.getPraiseId(),1L);
        hotUtils.redCommentHot(praise.getPraiseId(),3L);
        return praiseUtils.getComPraCount(praise.getPraiseId());
    }
}
