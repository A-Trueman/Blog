package com.service.impl;

import com.bo.Attention;
import com.common.util.BlogUtils;
import com.dao.AttentionDao;
import com.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lincg on 2017/5/30.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class AttentionServiceImpl implements AttentionService{

    @Autowired
    private AttentionDao attentionDao;


    /**
     * 是否关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 结果
     */
    public int isAttention(String username, String authorName) {
        return attentionDao.isAttention(username, authorName);
    }


    /**
     * 添加关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 关注结果
     */
    public int saveAttention(String username, String authorName) {
        Attention attention = new Attention();
        attention.setId(BlogUtils.getUUID());
        attention.setUsername(username);
        attention.setAuthorName(authorName);
        attention.setCreateTime(BlogUtils.getTime());

        return  attentionDao.saveAttention(attention);
    }


    /**
     * 取消用户名
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 取消结果
     */
    public int cancelAttention(String username, String authorName) {
        return attentionDao.deleteAttention(username, authorName);
    }


    /**
     * 查找Followee
     *
     * @param username 用户名
     *
     * @return Followee
     */
    public List<String> getFollowee(String username) {
        return attentionDao.getFollowees(username);
    }
}
