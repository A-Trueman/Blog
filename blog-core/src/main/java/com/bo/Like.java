package com.bo;

import java.io.Serializable;

/**
 * Created by Lincg on 2017/5/19.
 */
public class Like implements Serializable{
    //收藏id
    private String id;

    //博文id
    private String articleId;

    //标题
    private String title;

    //用户id
    private String userId;

    //用户名
    private String username;

    //作者id
    private String author_id;

    //作者名
    private String author_name;

    //标签
    private String tag;

    //博文存储url
    private String url;

    //博文预览
    private String preArticle;

    //收藏时间
    private Long createTime;

    //博文创建时间
    private Long articleCreateTime;

    //阅读数量
    private Integer readCounts;

    //收藏数量
    private Integer likes;

    //评论数量
    private Integer comments;

    //状态
    private Byte status;

    public Like() {}

    public Like(String id,
                String articleId,
                String title,
                String userId,
                String username,
                String author_id,
                String author_name,
                String tag,
                String url,
                String preArticle,
                Long createTime,
                Long articleCreateTime,
                Integer readCounts,
                Integer likes,
                Integer comments,
                Byte status) {
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Long articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
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
