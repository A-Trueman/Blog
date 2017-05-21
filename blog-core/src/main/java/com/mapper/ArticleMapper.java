package com.mapper;

import com.bo.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/21.
 */
public interface ArticleMapper {

    /**
     * 插入博文
     *
     * @param article 博文
     *
     * @return 是否插入成功
     */
    int insertArticle(Article article);


    /**
     * 查找用户公开博文
     *
     * @param username 用户名
     *
     * @return 博文
     */
    List<Article> selectUserPublicArticle(String username);


    /**
     * 查找用户私密博文
     *
     * @param username 用户名
     *
     * @return 博文
     */
    List<Article> selectUserPrivateArticle(String username);


    /**
     * 查找用户指定标签的公开博文
     *
     * @param map 用户名和标签
     *
     * @return 博文
     */
    List<Article> selectUserTagPublicArticle(Map<String, Object> map);


    /**
     * 查找用户指定标签的公开博文
     *
     * @param map 用户名和标签
     *
     * @return 私密博文
     */
    List<Article> selectUserTagPrivateArticle(Map<String, Object> map);


    /**
     * 查找指定标签的文章
     *
     * @param map 查询条件
     *
     * @return 博文
     */
    List<Article> selectTagArticle(Map<String, Object> map);


    /**
     * 查找关注的用户文章
     *
     * @param map 查询条件
     *
     * @return 博文
     */
    List<Article> selectUsersArticle(Map<String, Object> map);

}