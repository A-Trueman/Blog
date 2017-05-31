package com.service;

import com.bo.Article;

import java.util.List;
import java.util.Map;

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
	List<Article> getUserArticleList(String username,
									 String lastDateTime,
									 String lessDateTime,
									 Byte status);


	/**
	 * 查找博文
	 *
	 * @param articleId 博文id
	 *
	 * @return 博文
	 */
	Article selectArticleById(String articleId);


	/**
	 * 查找文章数量最多的标签
	 *
	 * @param username 用户名
	 * @param status 文章状态
	 *
	 * @return 标签
	 */
	List<Map<String, Object>>  selectTagsByUsername(String username, Byte status);


	/**
	 * 查找用户指定标签的文章列表
	 *
	 * @param username 用户名
	 * @param tag 标签
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文列表
	 */
	List<Article> getUserTagArticleList(String username,
										String tag,
										String lastDateTime,
										String lessDateTime,
										Byte status);


	/**
	 * 查找博文
	 *
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文列表
	 */
	List<Article> getArticleList(String lastDateTime,
								 String lessDateTime,
								 Byte status);


	List<Article> getArticleTagList(String tag,
									String lastDateTime,
									String lessDateTime,
									Byte status);


	/**
	 * 获得重复次数多的标签
	 *
	 * @param status 状态
	 *
	 * @return 标签
	 */
	List<String> getTags(Byte status);


	/**
	 * 查找用户们的博文列表
	 *
	 * @param usernames 用户名列表
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文列表
	 */
	List<Article> getUsersArticles(List<String> usernames,
	                               String lastDateTime,
	                               String lessDateTime,
	                               Byte status);
}
