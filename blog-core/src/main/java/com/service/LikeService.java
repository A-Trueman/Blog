package com.service;

import com.bo.Like;

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
}
