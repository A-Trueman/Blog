package com.dao.impl;

import com.bo.Article;
import com.dao.ArticleDao;
import com.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nuomifan on 2017/5/22.
 */

@Repository
public class ArticleDaoImpl implements ArticleDao{


	/** 博文操作Mapper */
	@Autowired
	private ArticleMapper articleMapper;


	/**
	 * 插入博文
	 *
	 * @param article 博文
	 *
	 * @return 是否插入成功
	 */
	public int insertArticle(Article article) {
		return articleMapper.insertArticle(article);
	}


	/**
	 * 查找博文
	 *
	 * @param articleId 博文id
	 *
	 * @return 博文
	 */
	public Article selectArticleById(String articleId) {
		return articleMapper.selectArticleById(articleId);
	}


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
	public List<Article> selectUserArticle(String username,
	                                       Long lastDateTime,
	                                       Long lessDateTime,
	                                       Byte status) {

		Map<String, Object> cond = new HashMap<>();
		cond.put("username", username);
		cond.put("lastDataTime", lastDateTime);
		cond.put("lessDataTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectUserArticle(cond);
	}



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
	public List<Article> selectUserTagArticle(String username,
	                                          String tag,
	                                          Long lastDateTime,
	                                          Long lessDateTime,
	                                          Byte status) {

		Map<String, Object> cond = new HashMap<>();
		cond.put("username", username);
		cond.put("tag", tag);
		cond.put("lastDataTime", lastDateTime);
		cond.put("lessDataTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectUserTagArticle(cond);
	}


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
	public List<Article> selectTagArticle(String tag,
	                                      Long lastDateTime,
	                                      Long lessDateTime,
	                                      Byte status) {

		Map<String, Object> cond = new HashMap<>();
		cond.put("tag", tag);
		cond.put("lastDataTime", lastDateTime);
		cond.put("lessDataTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectTagArticle(cond);
	}


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
	public List<Article> selectUsersArticle(List<String> usernames,
	                                        Long lastDateTime,
	                                        Long lessDateTime,
	                                        Byte status) {

		Map<String, Object> cond = new HashMap<>();
		cond.put("usernames", usernames);
		cond.put("lastDataTime", lastDateTime);
		cond.put("lessDataTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectUsersArticle(cond);
	}
}
