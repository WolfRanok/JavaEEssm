package com.jinzheng.dao;

import com.jinzheng.pojo.User;

public interface UserMapper {
    // 根据用户名查找用户
    User selectByUser(User user);

    //注册功能（添加用户）
    void addUser(User user);

    //注销功能(删除用户)
    void deleteUser(String username);

    //修改用户信息
    void updateUser(User user);
}