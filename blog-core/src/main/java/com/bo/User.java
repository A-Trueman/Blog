package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/14.
 */
public class User implements Serializable{

    //用户ID
    public String id;

    //用户名
    public String username;

    //博客名称
    public String blogName;

    //用户姓名
    public String name;

    //用户密码
    public String password;

    //头像地址
    public String avatar;

    //邮箱
    public String email;

    //微博
    public String weibo;

    //GitHub地址
    public String github;

    //地址
    public String address;

    //手机号
    public String phone;

    //描述字段
    public String description;

    //性别
    public int sex;

    //注册时间
    public long createTime;

    //上次登录时间
    public long lastLoginTime;

    //状态
    public int status;

    //扩展字段
    public String expansion;

    public User() {}


    public User(String id, String username, String blogName,
                String name, String password, String avatar,
                String email, String weibo, String github,
                String address, String phone, String description,
                int sex, long createTime, long lastLoginTime,
                int status, String expansion) {
        this.id = id;
        this.username = username;
        this.blogName = blogName;
        this.name = name;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
        this.weibo = weibo;
        this.github = github;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.sex = sex;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
        this.expansion = expansion;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void  setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }
}
