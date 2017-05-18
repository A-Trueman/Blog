package com.dao.impl;

import com.bo.User;
import com.dao.UserDao;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Lincg on 2017/5/16.
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;


    /**
     * 插入用户
     *
     * @param user 用户信息
     *
     * @return 插入件数
     */
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }


    /**
     * 获得用户信息
     *
     * @param username 用户名
     *
     * @return 用户信息
     */
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


    /**
     * 获得用户信息
     *
     * @param id 用户id
     *
     * @return 用户信息
     */
    public User getUserById(String id) {
        return userMapper.selectById(id);
    }


    /**
     * 获取用户密码
     *
     * @param username 用户名
     *
     * @return 用户密码
     */
    public String getPassword(String username) {
        return userMapper.selectPwdByUsername(username);
    }


    /**
     * 用户名是否存在
     *
     * @param username
     *
     * @return
     */
    public boolean isExits(String username) {
        String password = userMapper.selectPwdByUsername(username);
        if (password != null && !password.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
