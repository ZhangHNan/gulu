package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.mapper.WatchMapper;
import wanzhi.gulu.community.model.Watch;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.WatchUtils;

@Service
public class WatchService {

    @Autowired
    WatchUtils watchUtils;

    @Autowired
    WatchMapper watchMapper;

    @Autowired
    HotUtils hotUtils;

    //关注、取消关注
    @Transactional
    public void updateWatch(Long loginId, Long id) {
        Watch dbWatch = watchUtils.checkWatch(loginId,id);
        if (dbWatch!=null){
            //取消关注
            watchMapper.deleteByPrimaryKey(dbWatch.getId());
            watchUtils.redFans(id,1L);
            hotUtils.redUserHot(id,8L);
        }else {
            //关注
            Watch watch = new Watch();
            watch.setCollector(loginId);
            watch.setWatchId(id);
            watch.setGmtCreate(System.currentTimeMillis());
            watchMapper.insert(watch);
            watchUtils.incFans(id,1L);
            hotUtils.incUserHot(id,8L);
        }
    }
}
