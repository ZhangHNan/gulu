package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.UserExtMapper;
import wanzhi.gulu.community.mapper.WatchMapper;
import wanzhi.gulu.community.model.Watch;
import wanzhi.gulu.community.model.WatchExample;

import java.util.List;

//关注工具类
@Component
public class WatchUtils {

    @Autowired
    UserExtMapper userExtMapper;

    @Autowired
    WatchMapper watchMapper;

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

    public Boolean isWatch(Long loginId, Long id) {
        WatchExample example = new WatchExample();
        example.createCriteria()
                .andCollectorEqualTo(loginId)
                .andWatchIdEqualTo(id);
        List<Watch> watches = watchMapper.selectByExample(example);
        return watches.size() != 0;
    }

    public Watch checkWatch(Long loginId, Long id) {
        WatchExample example = new WatchExample();
        example.createCriteria()
                .andCollectorEqualTo(loginId)
                .andWatchIdEqualTo(id);
        List<Watch> watches = watchMapper.selectByExample(example);
        if (watches.size()!=0){
            return watches.get(0);
        }
        return null;
    }
}
