package com.mapper;

import com.bo.User;
import org.springframework.stereotype.Component;

/**
 * Created by Lincg on 2017/5/16.
 */
public interface UserMapper {

    /**
     * 插入用户
     *
     * @param user 用户信息
     *
     * @return 是否成功
     */
    int insertUser(User user);


    /**
     * 通过用户id查找用户信息
     *
     * @param id 用户id
     *
     * @return 用户信息
     */
    User selectById(String id);


    /**
     * 通过用户名查找用户信息
     *
     * @param username 用户名
     *
     * @return 用户信息
     */
    User selectByUsername(String username);


    /**
     * 查找用户密码
     *
     * @param username 用户名
     *
     * @return 用户密码
     */
    String selectPwdByUsername(String username);


    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     *
     * @return 用户名
     */
    @Deprecated
    int selectUsername(String username);
}
