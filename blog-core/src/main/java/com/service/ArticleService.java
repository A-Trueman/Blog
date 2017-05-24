package com.service;

import com.bo.Article;

import java.util.List;

/**
 * Created by nuomifan on 2017/5/22.
 */
public interface ArticleService {


	int saveArticle(Article article);


	List<Article> getUserArticleList(String username, String lastDateTime, String lessDateTime);
}
