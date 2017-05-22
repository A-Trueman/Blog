package com.dao;

import com.bo.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by nuomifan on 2017/5/22.
 */
public interface ArticleDao {


	/**
	 * 插入博文
	 *
	 * @param article 博文
	 *
	 * @return 是否插入成功
	 */
	int insertArticle(Article article);


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
	List<Article> selectUserArticle(String username,
	                                long lastDateTime,
	                                long lessDateTime,
	                                int status);



	/**
	 * 查找用户指定标签的博文（分页）
	 *
	 * @param username 用户名
	 * @param tag 标签
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 1：public，2：private
	 *
	 * @return 博文
	 */
	List<Article> selectUserTagArticle(String username,
	                                   String tag,
	                                   long lastDateTime,
	                                   long lessDateTime,
	                                   int status);


	/**
	 * 查找指定标签的文章（分页）
	 *
	 * @param map 查询条件
	 *
	 * @return 博文
	 */
	/**
	 * 查找指定标签的文章（分页）
	 *
	 * @param tag 标签
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文
	 */
	List<Article> selectTagArticle(String tag,
	                               long lastDateTime,
	                               long lessDateTime,
	                               int status);


	/**
	 * 查找关注的用户文章
	 *
	 * @param map 查询条件
	 *
	 * @return 博文
	 */
	/**
	 * 查找关注的用户文章
	 *
	 * @param usernames 关注的用户名
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文
	 */
	List<Article> selectUsersArticle(List<String> usernames,
	                                 long lastDateTime,
	                                 long lessDateTime,
	                                 int status);
}