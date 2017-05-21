package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Article implements Serializable{

    //博文id
    public String id;

    //标题
    public String title;

    //作者id
    public String userId;

    //作者名
    public String username;

    //标签
    public String tag;

    //存储URL
    public String url;

    //博文预览
    public String preArticle;

    //创建时间
    public long createTime;

    //阅读数量
    public int readCounts;

    //收藏数量
    public int likes;

    //评论数量
    public int comments;

    //状态 0：无效，1：公开，2：私密
    public int status;

    public Article() {}

    public Article(String id, String title, String userId, String username, String tag, String url, String preArticle, long createTime, int readCounts, int likes, int comments, int status) {
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getReadCounts() {
        return readCounts;
    }

    public void setReadCounts(int readCounts) {
        this.readCounts = readCounts;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
