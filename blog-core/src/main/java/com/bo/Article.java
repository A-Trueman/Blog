package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Article implements Serializable{

    //博文id
    private String id;

    //标题
    private String title;

    //作者id
    private String userId;

    //作者名
    private String username;

    //标签
    private String tag;

    //存储URL
    private String url;

    //博文预览
    private String preArticle;

    //创建时间
    private Long createTime;

    //阅读数量
    private Integer readCounts;

    //收藏数量
    private Integer likes;

    //评论数量
    private Integer comments;

    //状态 0：无效，1：公开，2：私密
    private Byte status;

    public Article() {}

    public Article(String id,
                   String title,
                   String userId,
                   String username,
                   String tag,
                   String url,
                   String preArticle,
                   Long createTime,
                   Integer readCounts,
                   Integer likes,
                   Integer comments,
                   Byte status) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.username = username;
        this.tag = tag;
        this.url = url;
        this.preArticle = preArticle;
        this.createTime = createTime;
        this.readCounts = readCounts;
        this.likes = likes;
        this.comments = comments;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreArticle() {
        return preArticle;
    }

    public void setPreArticle(String preArticle) {
        this.preArticle = preArticle;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getReadCounts() {
        return readCounts;
    }

    public void setReadCounts(Integer readCounts) {
        this.readCounts = readCounts;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
