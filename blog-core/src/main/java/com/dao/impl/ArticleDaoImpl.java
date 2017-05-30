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
	 * 插入博文或更新
	 *
	 * @param article 博文
	 *
	 * @return 是否插入成功
	 */
	public int replaceArticle(Article article) {
		return articleMapper.replaceArticle(article);
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
		cond.put("lastDateTime", lastDateTime);
		cond.put("lessDateTime", lessDateTime);
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
		cond.put("lastDateTime", lastDateTime);
		cond.put("lessDateTime", lessDateTime);
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
		cond.put("lastDateTime", lastDateTime);
		cond.put("lessDateTime", lessDateTime);
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
		cond.put("lastDateTime", lastDateTime);
		cond.put("lessDateTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectUsersArticle(cond);
	}


	/**
	 * 查找文章数量最多的标签
	 *
	 * @param username 用户名
	 * @param status 文章状态
	 *
	 * @return 标签
	 */
	public List<Map<String, Object>> selectTagsByUsername(String username, Byte status) {
		Map<String, Object> cond = new HashMap<>();

		cond.put("username", username);
		cond.put("status", status);

		return articleMapper.selectTagsByUsername(cond);
	}


	/**
	 * 获得博文列表
	 *
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文
	 */
	public List<Article> selectArticleList(Long lastDateTime,
										   Long lessDateTime,
										   Byte status) {
		Map<String, Object> cond = new HashMap<>();

		cond.put("lastDateTime", lastDateTime);
		cond.put("lessDateTime", lessDateTime);
		cond.put("status", status);

		return articleMapper.selectArticleList(cond);
	}


	/**
	 * 获得标签列表
	 *
	 * @param status 状态
	 *
	 * @return 标签
	 */
	public List<String> selectTags(Byte status) {
		return articleMapper.selectTags(status);
	}
}
