package com.vo;

import java.io.Serializable;

/**
 * Created by nuomifan on 2017/5/22.
 */
public class ArticleVo implements Serializable{

	//博文id
	private String id;

	//用户名
	private String username;

	//用户blog列表链接
	private String usernameUrl;

	//标题
	private String title;

	//标签
	private String tag;

	//标签blog列表链接
	private String tagUrl;

	//创建时间
	private String createTime;

	//预览
	private String preArticle;

	//正文跳转地址
	private String articleUrl;

	//正文实际地址
	private String articleRealUrl;

	//阅读数量
	private int readCounts;

	public ArticleVo() {}

	public ArticleVo(String id,
					 String username,
					 String usernameUrl,
					 String title,
					 String tag,
					 String tagUrl,
					 String createTime,
					 String preArticle,
					 String articleUrl,
					 String articleRealUrl,
					 int readCounts) {
		this.id = id;
		this.username = username;
		this.usernameUrl = usernameUrl;
		this.title = title;
		this.tag = tag;
		this.tagUrl = tagUrl;
		this.createTime = createTime;
		this.preArticle = preArticle;
		this.articleUrl = articleUrl;
		this.articleRealUrl = articleRealUrl;
		this.readCounts = readCounts;
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

	public String getUsernameUrl() {
		return usernameUrl;
	}

	public void setUsernameUrl(String usernameUrl) {
		this.usernameUrl = usernameUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTagUrl() {
		return tagUrl;
	}

	public void setTagUrl(String tagUrl) {
		this.tagUrl = tagUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPreArticle() {
		return preArticle;
	}

	public void setPreArticle(String preArticle) {
		this.preArticle = preArticle;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getArticleRealUrl() {
		return articleRealUrl;
	}

	public void setArticleRealUrl(String articleRealUrl) {
		this.articleRealUrl = articleRealUrl;
	}

	public int getReadCounts() {
		return readCounts;
	}

	public void setReadCounts(int readCounts) {
		this.readCounts = readCounts;
	}
}
