package com.service.impl;

import com.bo.Like;
import com.dao.LikeDao;
import com.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lincg on 2017/5/29.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeDao likeDao;

    /**
     * 保存收藏
     *
     * @param like 收藏信息
     *
     * @return 是否成功
     */
    public int saveLike(Like like) {
        if (likeDao.getLike(like.getUsername(), like.getArticleId(), like.getStatus()) != null) {
            return 0;
        }
        return likeDao.saveLike(like);
    }


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
        return likeDao.getLike(username, articleId, status);
    }


    /**
     * 取消收藏
     *
     * @param username 用户名
     * @param articleId 博文id
     *
     * @return 删除结果
     */
    public int deleteLike(String username, String articleId) {
        return likeDao.deleteLike(username, articleId);
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
                                  String lastDateTime,
                                  String  lessDateTime,
                                  Byte status) {
        Long lastTime = null, lessTime = null;

        if (lastDateTime != null && !lastDateTime.isEmpty()) {
            lastTime = Long.parseLong(lastDateTime);
        }
        if (lessDateTime != null && !lessDateTime.isEmpty()) {
            lessTime = Long.parseLong(lessDateTime);
        }

        return likeDao.getLikeList(username, lastTime, lessTime, status);
    }


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
    public List<Like> getLikeTagList(String username,
                                     String tag,
                                     String lastDateTime,
                                     String  lessDateTime,
                                     Byte status) {
        Long lastTime = null, lessTime = null;

        if (lastDateTime != null && !lastDateTime.isEmpty()) {
            lastTime = Long.parseLong(lastDateTime);
        }
        if (lessDateTime != null && !lessDateTime.isEmpty()) {
            lessTime = Long.parseLong(lessDateTime);
        }

        return likeDao.getLikeTagList(username, tag, lastTime, lessTime, status);
    }


    /**
     * 获取标签
     *
     * @param username 用户名
     * @param status 状态
     *
     * @return 标签
     */
    public List<String> getTags(String username, Byte status) {
        return likeDao.selectTags(username, status);
    }
}
