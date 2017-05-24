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

	public static ArticleVo convert2ArticleVo(Article article) {
		ArticleVo articleVo = new ArticleVo();
		articleVo.setTitle(article.getTitle());
		articleVo.setUsername(article.getUsername());
		articleVo.setUsernameUrl(SystemConst.USER_BLOG_PATH + article.getUsername());
		articleVo.setArticleUrl(SystemConst.ARTICLE_PATH + article.getId());
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

	public static List<ArticleVo> convert2ArticleVos(List<Article> articles) {
		List<ArticleVo> articleVos = new ArrayList<>();
		for (Article article : articles) {
			articleVos.add(convert2ArticleVo(article));
		}
		return articleVos;
	}
}
