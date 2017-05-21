package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Like implements Serializable{
    //收藏id
    public String id;

    //博文id
    public String articleId;

    //标题
    public String title;

    //用户id
    public String userId;

    //用户名
    public String username;

    //作者id
    public String author_id;

    //作者名
    public String author_name;

    //标签
    public String tag;

    //博文存储url
    public String url;

    //博文预览
    public String preArticle;

    //收藏时间
    public long createTime;

    //博文创建时间
    public long articleCreateTime;

    //阅读数量
    public int readCounts;

    //收藏数量
    public int likes;

    //评论数量
    public int comments;

    //状态
    public int status;

    public Like() {}

    public Like(String id, String articleId, String title, String userId, String username, String author_id, String author_name, String tag, String url, String preArticle, long createTime, long articleCreateTime, int readCounts, int likes, int comments, int status) {
        this.id = id;
        this.articleId = articleId;
        this.title = title;
        this.userId = userId;
        this.username = username;
        this.author_id = author_id;
        this.author_name = author_name;
        this.tag = tag;
        this.url = url;
        this.preArticle = preArticle;
        this.createTime = createTime;
        this.articleCreateTime = articleCreateTime;
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

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
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

    public long getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(long articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
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
