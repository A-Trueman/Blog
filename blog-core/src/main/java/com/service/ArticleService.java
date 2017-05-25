package com.service;

import com.bo.Article;

import java.util.List;

/**
 * Created by nuomifan on 2017/5/22.
 */
public interface ArticleService {


	int saveArticle(Article article);


	/**
	 * 查找用户博文（分页）
	 *
	 * @param username 用户名
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 1：public，2：private
	 *
	 * @return 博文
	 */
	List<Article> getUserArticleList(String username, String lastDateTime, String lessDateTime, Byte status);


	/**
	 * 查找博文
	 *
	 * @param articleId 博文id
	 *
	 * @return 博文
	 */
	Article selectArticleById(String articleId);
}
