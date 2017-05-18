package com.mapper;

import com.bo.User;
import org.springframework.stereotype.Component;

/**
 * Created by Lincg on 2017/5/16.
 */
public interface UserMapper {

    public int insertUser(User user);

    public User selectById(String id);

    public User selectByUsername(String username);

    public String selectPwdByUsername(String username);

    public int selectUsername(String username);
}
