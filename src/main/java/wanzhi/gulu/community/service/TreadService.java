package wanzhi.gulu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.PraiseCreateDTO;
import wanzhi.gulu.community.dto.TreadCreateDTO;
import wanzhi.gulu.community.mapper.PraiseMapper;
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.mapper.TreadMapper;
import wanzhi.gulu.community.model.*;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.PraiseUtils;
import wanzhi.gulu.community.util.TreadUtils;

import java.util.List;

@Service
public class TreadService {

    @Autowired
    TreadMapper treadMapper;

    @Autowired
    TreadUtils treadUtils;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    HotUtils hotUtils;

    public Tread checkTreadStatus(TreadCreateDTO treadCreateDTO) {
        TreadExample example = new TreadExample();
        example.createCriteria()
                .andCreatorEqualTo(treadCreateDTO.getCreator())
                .andTreadIdEqualTo(treadCreateDTO.getTreadId())
                .andTypeEqualTo(treadCreateDTO.getType());
        List<Tread> treads = treadMapper.selectByExample(example);
        if (treads.size()!=0){
            return treads.get(0);
        }
        return null;
    }

    @Transactional
    public Long createQuestionTread(TreadCreateDTO treadCreateDTO) {
        Tread tread = new Tread();
        tread.setGmtCreate(System.currentTimeMillis());
        BeanUtils.copyProperties(treadCreateDTO,tread);
        //创建tread数据
        treadMapper.insert(tread);
        //增加问题treadCount
        treadUtils.incQuestionTread(treadCreateDTO.getTreadId(),1L);
        //热度值
        hotUtils.redQuestionHot(treadCreateDTO.getTreadId(),4L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(treadCreateDTO.getTreadId());
        hotUtils.redUserHot(targetQuestion.getCreator(),4L);
        //返回踩数
        return treadUtils.getQueTreCount(treadCreateDTO.getTreadId());

    }

    @Transactional
    public Long removeQuestionTread(Tread tread){
        treadMapper.deleteByPrimaryKey(tread.getId());
        treadUtils.redQuestionTread(tread.getTreadId(),1L);
        //热度值
        hotUtils.incQuestionHot(tread.getTreadId(),4L);
        Question targetQuestion = questionMapper.selectByPrimaryKey(tread.getTreadId());
        hotUtils.incUserHot(targetQuestion.getCreator(),4L);
        return treadUtils.getQueTreCount(tread.getTreadId());
    }

    @Transactional
    public Long createCommentTread(TreadCreateDTO treadCreateDTO) {
        Tread tread = new Tread();
        tread.setGmtCreate(System.currentTimeMillis());
        BeanUtils.copyProperties(treadCreateDTO,tread);
        //创建tread数据
        treadMapper.insert(tread);
        //增加评论treadCount
        treadUtils.incCommentTread(treadCreateDTO.getTreadId(),1L);
        //热度值
        hotUtils.redCommentHot(treadCreateDTO.getTreadId(),4L);
        //返回踩数
        return treadUtils.getComTreCount(treadCreateDTO.getTreadId());
    }

    @Transactional
    public Long removeCommentTread(Tread tread) {
        treadMapper.deleteByPrimaryKey(tread.getId());
        treadUtils.redCommentTread(tread.getTreadId(),1L);
        hotUtils.incCommentHot(tread.getTreadId(),4L);
        return treadUtils.getComTreCount(tread.getTreadId());
    }
}
