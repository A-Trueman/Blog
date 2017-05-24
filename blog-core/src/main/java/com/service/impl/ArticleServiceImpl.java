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


	public List<Article> getUserArticleList(String username, String lastDateTime, String lessDateTime) {

		Long lastTime = null, lessTime = null;

		if (lastDateTime != null && !lastDateTime.isEmpty()) {
			lastTime = Long.parseLong(lastDateTime);
		}
		if (lessDateTime != null && !lessDateTime.isEmpty()) {
			lessTime = Long.parseLong(lessDateTime);
		}

		return articleDao.selectUserArticle(username, lastTime, lessTime, Byte.valueOf("1"));
	}


}
