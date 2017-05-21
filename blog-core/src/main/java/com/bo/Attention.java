package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Attention implements Serializable{

    //ID
    public String id;

    //用户名
    public String username;

    //用户ID
    public String userId;

    //关注人名称
    public String authorName;

    //关注人ID
    public String authorId;

    //关注时间
    public String createTime;

    public Attention() {}

    public Attention(String id, String username, String userId, String authorName, String authorId, String createTime) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.authorName = authorName;
        this.authorId = authorId;
        this.createTime = createTime;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
