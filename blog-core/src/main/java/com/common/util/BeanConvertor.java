package com.common.util;

import com.bo.Article;
import com.common.SystemConst;
import com.vo.ArticleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nuomifan on 2017/5/24.
 */
public class BeanConvertor {

	public static ArticleVo convert2ArticleVo(Article article,Byte type) {
		ArticleVo articleVo = new ArticleVo();
		articleVo.setTitle(article.getTitle());
		articleVo.setUsername(article.getUsername());
		articleVo.setUsernameUrl(SystemConst.USER_BLOG_PATH + article.getUsername());
		//type 1:查看自己文章 0：查看他人文章
		if (type == 1) {
			articleVo.setArticleUrl(SystemConst.My_ARTICLE_PATH + article.getId() + ".html");
		} else {
			articleVo.setArticleUrl(SystemConst.OTHER_ARTICLE_PATH + article.getId() + ".html");
		}
		articleVo.setArticleRealUrl(SystemConst.HTML_URL + article.getId() + ".htm");
		articleVo.setCreateTime(BlogUtils.longTime2Text(article.getCreateTime()));
		if(article.getPreArticle().trim().length() == 128) {
			articleVo.setPreArticle(article.getPreArticle() + "...");
		} else {
			articleVo.setPreArticle(article.getPreArticle());
		}
		articleVo.setTag(article.getTag());
		articleVo.setReadCounts(article.getReadCounts());
		return articleVo;
	}

	public static List<ArticleVo> convert2ArticleVos(List<Article> articles,Byte type) {
		List<ArticleVo> articleVos = new ArrayList<>();
		for (Article article : articles) {
			articleVos.add(convert2ArticleVo(article, type));
		}
		return articleVos;
	}
}
