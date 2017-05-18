package com.service;

import com.bo.User;

/**
 * Created by Lincg on 2017/5/16.
 */
public interface UserService {


    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @param phone 手机
     * @param sex 性别
     *
     * @return 1：注册成功，0：失败
     */
    int registerUser(String username,
                     String password,
                     String email,
                     String phone,
                     int sex);


    /**
     * 用户注册
     *
     * @param user 用户信息
     *
     * @return 1：注册成功，0：失败
     */
    int registerUser(User user);


    boolean login(String username, String password);
}
