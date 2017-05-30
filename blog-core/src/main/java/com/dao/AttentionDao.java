package com.dao;

import com.bo.Attention;

import java.util.List;

/**
 * Created by Lincg on 2017/5/30.
 */
public interface AttentionDao {

    /**
     * 添加关注
     *
     * @param attention 关注信息
     *
     * @return 关注结果
     */
    int saveAttention(Attention attention);


    /**
     * 取消关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 删除结果
     */
    int deleteAttention(String username, String authorName);


    /**
     * 是否关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 关注结果
     */
    int isAttention(String username, String authorName);


    /**
     * 获取关注列表
     *
     * @param username 用户名
     *
     * @return 关注列表
     */
    List<String> getFollowees(String username);
}
