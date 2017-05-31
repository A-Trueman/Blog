package com.dao.impl;

import com.bo.Like;
import com.dao.LikeDao;
import com.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/29.
 */
@Repository
public class LikeDaoImpl implements LikeDao {

    @Autowired
    private LikeMapper likeMapper;

    /**
     * 查找收藏
     *
     * @param username 用户名
     * @param articleId 博文id
     * @param status 状态
     *
     * @return 收藏
     */
    public Like getLike(String username, String articleId, Byte status) {
        Map<String, Object> map = new HashMap<>();

        map.put("username", username);
        map.put("articleId", articleId);
        map.put("status", status);
        return likeMapper.selectLike(map);
    }


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
    public List<Like> getLikeList(String username,
                                  Long lastDateTime,
                                  Long lessDateTime,
                                  Byte status) {
        Map<String, Object> cond = new HashMap<>();
        cond.put("username", username);
        cond.put("lastDateTime", lastDateTime);
        cond.put("lessDateTime", lessDateTime);
        cond.put("status", status);

        return likeMapper.selectLikeList(cond);
    }


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
    public List<Like> getLikeTagList(String username,
                                     String tag,
                                     Long lastDateTime,
                                     Long lessDateTime,
                                     Byte status) {
        Map<String, Object> cond = new HashMap<>();

        cond.put("username", username);
        cond.put("tag", tag);
        cond.put("lastDateTime", lastDateTime);
        cond.put("lessDateTime", lessDateTime);
        cond.put("status", status);

        return likeMapper.selectLikeTagList(cond);
    }


    /**
     * 保存收藏
     *
     * @param like 收藏信息
     *
     * @return 是否成功
     */
    public int saveLike(Like like) {
        return likeMapper.replaceLike(like);
    }


    /**
     * 取消收藏
     *
     * @param username 用户名
     * @param articleId 博文ID
     *
     * @return 删除结果
     */
    public int deleteLike(String username, String articleId) {
        Map<String, Object> cond = new HashMap<>();

        cond.put("username", username);
        cond.put("articleId", articleId);

        return likeMapper.deleteLike(cond);
    }


    /**
     * 查找标签
     *
     * @param username 用户名
     * @param status 状态
     *
     * @return 标签
     */
    public List<String> selectTags(String username, Byte status) {
        Map<String, Object> cond = new HashMap<>();

        cond.put("username", username);
        cond.put("status", status);

        return likeMapper.selectTags(cond);
    }
}
