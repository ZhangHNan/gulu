package wanzhi.gulu.community.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wanzhi.gulu.community.mapper.UserMapper;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.model.UserExample;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

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
}
