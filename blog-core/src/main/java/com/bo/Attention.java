package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Attention implements Serializable{

    //ID
    private String id;

    //用户名
    private String username;

    //用户ID
    private String userId;

    //关注人名称
    private String authorName;

    //关注人ID
    private String authorId;

    //关注时间
    private Long createTime;

    public Attention() {}

    public Attention(String id, String username, String userId, String authorName, String authorId, Long createTime) {
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
