package com.service;

import com.bo.Like;

import java.util.List;

/**
 * Created by Lincg on 2017/5/29.
 */
public interface LikeService {

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
     * @param articleId 博文id
     *
     * @return 删除结果
     */
    int deleteLike(String username, String articleId);


    /**
     * 查找收藏
     *
     * @param username 用户名
     * @param articleId 博文id
     * @param status 状态
     *
     * @return 收藏
     */
    Like getLike(String username, String articleId, Byte status);


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
                           String lastDateTime,
                           String  lessDateTime,
                           Byte status);


    /**
     * 获得指定标签的收藏列表
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
                              String lastDateTime,
                              String lessDateTime,
                              Byte status);


    /**
     * 获取标签
     *
     * @param username 用户名
     * @param status 状态
     *
     * @return 标签
     */
    List<String> getTags(String username, Byte status);
}
