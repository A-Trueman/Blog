package com.service.impl;

import com.bo.Article;
import com.dao.ArticleDao;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by nuomifan on 2017/5/22.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ArticleServiceImpl implements ArticleService{


	@Autowired
	private ArticleDao articleDao;

	public int saveArticle(Article article) {
		return articleDao.replaceArticle(article);
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
	public List<Article> getUserArticleList(String username, String lastDateTime, String lessDateTime, Byte status) {

		Long lastTime = null, lessTime = null;

		if (lastDateTime != null && !lastDateTime.isEmpty()) {
			lastTime = Long.parseLong(lastDateTime);
		}
		if (lessDateTime != null && !lessDateTime.isEmpty()) {
			lessTime = Long.parseLong(lessDateTime);
		}

		return articleDao.selectUserArticle(username, lastTime, lessTime, status);
	}


	/**
	 * 查找博文
	 *
	 * @param articleId 博文id
	 *
	 * @return 博文
	 */
	public Article selectArticleById(String articleId) {
		return articleDao.selectArticleById(articleId);
	}


	/**
	 * 查找文章数量最多的标签
	 *
	 * @param username 用户名
	 * @param status 文章状态
	 *
	 * @return 标签
	 */
	public List<Map<String, Object>>  selectTagsByUsername(String username, Byte status) {
		return articleDao.selectTagsByUsername(username, status);
	}


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
	public List<Article> getUserTagArticleList(String username,
											   String tag,
											   String lastDateTime,
											   String lessDateTime,
											   Byte status) {
		Long lastTime = null, lessTime = null;

		if (lastDateTime != null && !lastDateTime.isEmpty()) {
			lastTime = Long.parseLong(lastDateTime);
		}
		if (lessDateTime != null && !lessDateTime.isEmpty()) {
			lessTime = Long.parseLong(lessDateTime);
		}

		return articleDao.selectUserTagArticle(username, tag, lastTime, lessTime, status);
	}


	/**
	 * 查找博文
	 *
	 * @param lastDateTime 截止时间
	 * @param lessDateTime 起始时间
	 * @param status 状态
	 *
	 * @return 博文列表
	 */
	public List<Article> getArticleList(String lastDateTime,
										String lessDateTime,
										Byte status) {
		Long lastTime = null, lessTime = null;

		if (lastDateTime != null && !lastDateTime.isEmpty()) {
			lastTime = Long.parseLong(lastDateTime);
		}
		if (lessDateTime != null && !lessDateTime.isEmpty()) {
			lessTime = Long.parseLong(lessDateTime);
		}

		return articleDao.selectArticleList(lastTime, lessTime, status);
	}


	public List<Article> getArticleTagList(String tag,
										   String lastDateTime,
										   String lessDateTime,
										   Byte status) {
		Long lastTime = null, lessTime = null;

		if (lastDateTime != null && !lastDateTime.isEmpty()) {
			lastTime = Long.parseLong(lastDateTime);
		}
		if (lessDateTime != null && !lessDateTime.isEmpty()) {
			lessTime = Long.parseLong(lessDateTime);
		}

		return articleDao.selectTagArticle(tag, lastTime, lessTime, status);
	}


	/**
	 * 获得重复次数多的标签
	 *
	 * @param status 状态
	 *
	 * @return 标签
	 */
	public List<String> getTags(Byte status) {
		return articleDao.selectTags(status);
	}
}
