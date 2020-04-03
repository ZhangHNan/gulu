package wanzhi.gulu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanzhi.gulu.community.enums.NotificationStatusEnum;
import wanzhi.gulu.community.enums.NotificationTypeEnum;
import wanzhi.gulu.community.mapper.NotificationMapper;
import wanzhi.gulu.community.mapper.WatchMapper;
import wanzhi.gulu.community.model.Notification;
import wanzhi.gulu.community.model.NotificationExample;
import wanzhi.gulu.community.model.Watch;
import wanzhi.gulu.community.model.WatchExample;
import wanzhi.gulu.community.util.HotUtils;
import wanzhi.gulu.community.util.WatchUtils;

import java.util.List;

@Service
public class WatchService {

    @Autowired
    WatchUtils watchUtils;

    @Autowired
    WatchMapper watchMapper;

    @Autowired
    NotificationMapper notificationMapper;

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
            deleteWatchNotify(loginId,id);
        }else {
            //关注
            Watch watch = new Watch();
            watch.setCollector(loginId);
            watch.setWatchId(id);
            watch.setGmtCreate(System.currentTimeMillis());
            watchMapper.insert(watch);
            watchUtils.incFans(id,1L);
            hotUtils.incUserHot(id,8L);
            createWatchNotify(watch);
        }
    }

    //用于查询我的关注数放入session域中
    public Integer findMyWatchCount(Long id) {
        WatchExample example = new WatchExample();
        example.createCriteria()
                .andCollectorEqualTo(id);
        return watchMapper.countByExample(example);
    }

    //创建评论通知：传入被Watch对象即可
    private void createWatchNotify(Watch watch) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(NotificationTypeEnum.WATCH_FOR.getType());
        notification.setTypeName(NotificationTypeEnum.WATCH_FOR.getName());
        notification.setNotifier(watch.getCollector());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setOuterId(watch.getCollector());
        notification.setReceiver(watch.getWatchId());
        notification.setOuterTitle("了解");
        //注意：这里传入的comment是null，可以利用创建时间唯一性来从数据库中查找相应的comment
        WatchExample example = new WatchExample();
        example.createCriteria()
                .andGmtCreateEqualTo(watch.getGmtCreate());
        List<Watch> watches = watchMapper.selectByExample(example);
        if (watches.size()!=0){
            notification.setSourceId(watches.get(0).getId());
        }
        notificationMapper.insert(notification);
    }

    //删除评论通知：传入被Watch对象即可
    private void deleteWatchNotify(Long loginId, Long id) {
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andTypeEqualTo(NotificationTypeEnum.WATCH_FOR.getType())
                .andNotifierEqualTo(loginId)
                .andReceiverEqualTo(id);
        notificationMapper.deleteByExample(example);
    }
}
