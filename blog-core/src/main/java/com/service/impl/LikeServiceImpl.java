package com.service.impl;

import com.bo.Like;
import com.dao.LikeDao;
import com.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
