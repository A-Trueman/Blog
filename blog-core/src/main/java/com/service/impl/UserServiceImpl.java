package com.service.impl;

import com.bo.User;
import com.common.util.BlogUtils;
import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lincg on 2017/5/16.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @param phone 手机
     * @param sex 性别
     *
     * @return 1：注册成功，0：失败, 2:用户名重复
     */
    public int registerUser(String username,
                            String password,
                            String email,
                            String phone,
                            Byte sex) {
        User user = new User();
        if (userDao.isExits(username)) {
            return 2;
        }
        user.setId(BlogUtils.getUUID());
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setSex(sex);
        Long time = BlogUtils.getTime();
        user.setCreateTime(time);
        user.setLastLoginTime(time);
        return userDao.insertUser(user);
    }


    /**
     * 用户注册
     *
     * @param user 用户信息
     *
     * @return 1：注册成功，0：失败
     */
    public int registerUser(User user) {

        if (userDao.isExits(user.getUsername())) {
            return 2;
        }
        user.setId(BlogUtils.getUUID());
        Long time = BlogUtils.getTime();
        user.setCreateTime(time);
        user.setLastLoginTime(time);
        return userDao.insertUser(user);
    }


    public boolean login(String username, String password){
        if (username == null || username.isEmpty()) {
            return false;
        }
        String realPassword = userDao.getPassword(username);
        if (realPassword.trim().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
