package com.jinzheng.service.impl;

import com.jinzheng.dao.UserMapper;
import com.jinzheng.pojo.User;
import com.jinzheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired   //注解注入userMapper,实现调用
    private UserMapper userMapper;

    @Override
    public User selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(String userName) {
        userMapper.deleteUser(userName);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
