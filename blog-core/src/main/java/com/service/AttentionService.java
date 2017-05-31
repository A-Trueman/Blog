package com.service;

import java.util.List;

/**
 * Created by Lincg on 2017/5/30.
 */
public interface AttentionService {

    /**
     * 是否关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 结果
     */
    int isAttention(String username, String authorName);


    /**
     * 添加关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 关注结果
     */
    int saveAttention(String username, String authorName);


    /**
     * 取消用户名
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 取消结果
     */
    int cancelAttention(String username, String authorName);


    /**
     * 查找Followee
     *
     * @param username 用户名
     *
     * @return Followee
     */
    List<String> getFollowee(String username);
}
