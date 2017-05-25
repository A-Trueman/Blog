package com.service.impl;

import com.bo.Article;
import com.dao.ArticleDao;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nuomifan on 2017/5/22.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ArticleServiceImpl implements ArticleService{


	@Autowired
	private ArticleDao articleDao;

	public int saveArticle(Article article) {
		return articleDao.insertArticle(article);
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
}
