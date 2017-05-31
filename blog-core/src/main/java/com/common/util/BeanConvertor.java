package com.common.util;

import com.bo.Article;
import com.bo.Like;
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
		articleVo.setId(article.getId());
		articleVo.setTitle(article.getTitle());
		articleVo.setUsername(article.getUsername());
		articleVo.setUsernameUrl(SystemConst.USER_BLOG_PATH + article.getUsername() + ".html");
		//type 1:查看自己公平文章 2:查看私密文章 0：查看他人文章
		if (type == 1 || type == 2) {
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


	public static Like convertArticle2Like(Article article) {
		Like like = new Like();
		like.setArticleId(article.getId());
		like.setTitle(article.getTitle());
		like.setAuthorId(article.getUserId());
		like.setAuthorName(article.getUsername());
		like.setTag(article.getTag());
		like.setPreArticle(article.getPreArticle());
		like.setArticleCreateTime(article.getCreateTime());
		like.setReadCounts(article.getReadCounts());
		like.setLikes(article.getLikes());
		like.setComments(article.getComments());
		return like;
	}


	public static ArticleVo convertLike2ArticleVo(Like like) {
		ArticleVo articleVo = new ArticleVo();
		articleVo.setId(like.getArticleId());
		articleVo.setTitle(like.getTitle());
		articleVo.setUsername(like.getAuthorName());
		articleVo.setUsernameUrl(SystemConst.USER_BLOG_PATH + like.getAuthorName() + ".html");
		articleVo.setArticleUrl(SystemConst.OTHER_ARTICLE_PATH + like.getArticleId() + ".html");
		articleVo.setArticleRealUrl(SystemConst.HTML_URL + like.getArticleId() + ".htm");
		articleVo.setCreateTime(BlogUtils.longTime2Text(like.getArticleCreateTime()));
		if(like.getPreArticle().trim().length() == 128) {
			articleVo.setPreArticle(like.getPreArticle() + "...");
		} else {
			articleVo.setPreArticle(like.getPreArticle());
		}
		articleVo.setTag(like.getTag());
		articleVo.setReadCounts(like.getReadCounts());
		return articleVo;
	}


	public static List<ArticleVo> convertLikes2ArticleVos(List<Like> likes) {
		List<ArticleVo> articleVos = new ArrayList<>();
		for (Like like : likes) {
			articleVos.add(convertLike2ArticleVo(like));
		}
		return articleVos;
	}
}
