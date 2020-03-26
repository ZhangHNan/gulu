package wanzhi.gulu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.dto.PraiseCreateDTO;
import wanzhi.gulu.community.dto.TreadCreateDTO;
import wanzhi.gulu.community.mapper.PraiseMapper;
import wanzhi.gulu.community.mapper.TreadMapper;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.PraiseExample;
import wanzhi.gulu.community.model.Tread;
import wanzhi.gulu.community.model.TreadExample;
import wanzhi.gulu.community.util.PraiseUtils;
import wanzhi.gulu.community.util.TreadUtils;

import java.util.List;

@Service
public class TreadService {

    @Autowired
    TreadMapper treadMapper;

    @Autowired
    TreadUtils treadUtils;

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

        //返回踩数
        return treadUtils.getQueTreCount(treadCreateDTO.getTreadId());

    }

    @Transactional
    public Long removeQuestionTread(Tread tread){
        treadMapper.deleteByPrimaryKey(tread.getId());
        treadUtils.redQuestionTread(tread.getTreadId(),1L);
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

        //返回踩数
        return treadUtils.getComTreCount(treadCreateDTO.getTreadId());
    }

    @Transactional
    public Long removeCommentTread(Tread tread) {
        treadMapper.deleteByPrimaryKey(tread.getId());
        treadUtils.redCommentTread(tread.getTreadId(),1L);
        return treadUtils.getComTreCount(tread.getTreadId());
    }
}
