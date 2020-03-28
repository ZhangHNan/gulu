package wanzhi.gulu.community.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.dto.UserDTO;
import wanzhi.gulu.community.mapper.UserExtMapper;
import wanzhi.gulu.community.mapper.UserMapper;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.model.UserExample;
import wanzhi.gulu.community.model.Watch;
import wanzhi.gulu.community.util.PageUtils;
import wanzhi.gulu.community.util.WatchUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserExtMapper userExtMapper;

    @Autowired
    WatchUtils watchUtils;

    @Autowired
    PageUtils pageUtils;

    @Value("${page.notification.rows}")
    private Integer notificationRows;//设置通知页每页展示数据行数

    @Value("${page.notification.buttonCount}")
    private Integer notificationButtonCount;//设置通知页每页展示页面按钮数。请设置为奇数，设置为偶数中间段还是奇数个，头和尾才是偶数个


    //创建或更新用户：主要更新token
    public void createOrUpdate(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
//        User dbUser = userMapper.findByAccountId(user.getAccountId());
        //根据accountId判断数据库中有无这个user数据
//        if(dbUser == null){
        if(users.size() == 0){
            //如果没有，创建
//            userMapper.create(user);
            user.setGmtCreate(user.getGmtModified());
            user.setLikeCount(0L);
            user.setFansCount(0L);
            user.setHot(0L);
            user.setPower(0);
            userMapper.insert(user);
        }else{
            User dbUser = users.get(0);
            //如果有，只更新Token
//            userMapper.update(user);
            //如果头像、email、简介、name是空的话将github上的信息更新到账户信息中，如果有信息将其原样返回
            if (StringUtils.isNotBlank(dbUser.getAvatarUrl())){
                user.setAvatarUrl(dbUser.getAvatarUrl());
            }
            if (StringUtils.isNotBlank(dbUser.getEmail())){
                user.setEmail(dbUser.getEmail());
            }
            if(StringUtils.isNotBlank(dbUser.getBio())){
                user.setBio(dbUser.getBio());
            }
            if(StringUtils.isNotBlank(dbUser.getName())){
                user.setName(dbUser.getName());
            }
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(user,userExample1);
        }
    }

    public boolean checkAccountId(Long id) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountIdEqualTo(id);
        List<User> users = userMapper.selectByExample(example);
        return users.size() != 0;
    }

    public void binding(User loginUser) {
        userMapper.updateByPrimaryKey(loginUser);
    }

    public Boolean checkPhone(String data) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andPhoneEqualTo(data);
        List<User> users = userMapper.selectByExample(example);
        return users.size() != 0;
    }

    public UserDTO findUserDTOByid(Long id, Long loginId) {
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setWatch(watchUtils.isWatch(loginId,id));
        return userDTO;
    }

    public PageDTO findPageByWatch(Integer currentPage, Long id) {
        return pageUtils.autoStructureUserDTOByWatch(currentPage, notificationRows,notificationButtonCount,id);
    }
}
