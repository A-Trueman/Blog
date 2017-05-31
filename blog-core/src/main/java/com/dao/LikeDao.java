package com.dao;

import com.bo.Like;

import java.util.List;

/**
 * Created by Lincg on 2017/5/29.
 */
public interface LikeDao {

    /**
     * 查找收藏
     *
     * @param username 用户名
     * @param aticleId 博文id
     *
     * @return 收藏
     */
    Like getLike(String username,
                 String aticleId,
                 Byte status);


    /**
     * 获取收藏列表
     *
     * @param username 用户名
     * @param lastDateTime 截止时间
     * @param lessDateTime 起始时间
     * @param status 状态
     *
     * @return 收藏列表
     */
    List<Like> getLikeList(String username,
                           Long lastDateTime,
                           Long lessDateTime,
                           Byte status);


    /**
     * 获取指定标签收藏列表
     *
     * @param username 用户名
     * @param tag 标签
     * @param lastDateTime 截止时间
     * @param lessDateTime 起始时间
     * @param status 状态
     *
     * @return 收藏列表
     */
    List<Like> getLikeTagList(String username,
                              String tag,
                              Long lastDateTime,
                              Long lessDateTime,
                              Byte status);


    /**
     * 保存收藏
     *
     * @param like 收藏信息
     *
     * @return 是否成功
     */
    int saveLike(Like like);


    /**
     * 取消收藏
     *
     * @param username 用户名
     * @param articleId 博文ID
     *
     * @return 删除结果
     */
    int deleteLike(String username, String articleId);


    /**
     * 查找标签
     *
     * @param username 用户名
     * @param status 状态
     *
     * @return 标签
     */
    List<String> selectTags(String username, Byte status);
}
