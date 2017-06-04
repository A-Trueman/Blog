package com.mapper;

import com.bo.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/21.
 */
public interface ArticleMapper {

    /**
     * 插入或更新博文
     *
     * @param article 博文
     *
     * @return 是否插入成功
     */
    int replaceArticle(Article article);


    /**
     * 查找博文
     *
     * @param articleId 博文id
     *
     * @return 博文
     */
    Article selectArticleById(String articleId);


    /**
     * 查找用户博文
     *
     * @param map 查询条件
     *
     * @return 博文
     */
    List<Article> selectUserArticle(Map<String, Object> map);


    /**
     * 查找用户指定标签的博文
     *W
     * @param map 用户名和标签
     *
     * @return 博文
     */
    List<Article> selectUserTagArticle(Map<String, Object> map);



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


    /**
     * 查找重复次数最多的标签
     *
     * @param map 查询条件
     *
     * @return 标签列表
     */
    List<Map<String, Object>> selectTagsByUsername(Map<String, Object> map);


    /**
     * 获得博文列表
     *
     * @param map 查询条件
     *
     * @return 博文列表
     */
    List<Article> selectArticleList(Map<String, Object> map);

    /**
     * 获得标签列表
     *
     * @param status 状态
     *
     * @return 标签
     */
    List<String> selectTags(Byte status);


    /**
     * 查找博文
     *
     * @param cond 查询条件
     *
     * @return 博文
     */
    List<Article> selectArticleListByCond(Map<String, Object> cond);


    /**
     * 获取阅读数量
     *
     * @param articleId 博文ID
     *
     * @return 阅读数量
     */
    int selectReadCount(String articleId);
}
