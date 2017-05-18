package com.dao;

import com.bo.User;


/**
 * Created by Lincg on 2017/5/16.
 */
public interface UserDao {


    /**
     * 插入用户
     *
     * @param user 用户信息
     *
     * @return 插入件数
     */
    int insertUser(User user);


    /**
     * 获得用户信息
     *
     * @param username 用户名
     *
     * @return 用户信息
     */
    User getUserByUsername(String username);


    /**
     * 获得用户信息
     *
     * @param id 用户id
     *
     * @return 用户信息
     */
    User getUserById(String id);


    /**
     * 获取用户密码
     *
     * @param username 用户名
     *
     * @return 用户密码
     */
    String getPassword(String username);


    /**
     * 用户名是否存在
     *
     * @param username
     *
     * @return
     */
    boolean isExits(String username);
}
