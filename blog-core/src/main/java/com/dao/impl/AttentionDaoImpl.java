package com.dao.impl;

import com.bo.Attention;
import com.dao.AttentionDao;
import com.mapper.AttentionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/30.
 */
@Repository
public class AttentionDaoImpl implements AttentionDao{

    @Autowired
    private AttentionMapper attentionMapper;

    /**
     * 添加关注
     *
     * @param attention 关注信息
     *
     * @return 关注结果
     */
    public int saveAttention(Attention attention) {
        return attentionMapper.replaceAttention(attention);
    }


    /**
     * 取消关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 删除结果
     */
    public int deleteAttention(String username, String authorName) {
        Map<String, Object> cond = new HashMap<>();

        cond.put("username", username);
        cond.put("authorName", authorName);

        return attentionMapper.deleteAttention(cond);
    }


    /**
     * 是否关注
     *
     * @param username 用户名
     * @param authorName followee名
     *
     * @return 关注结果
     */
    public int isAttention(String username, String authorName) {
        Map<String, Object> cond = new HashMap<>();

        cond.put("username", username);
        cond.put("authorName", authorName);

        return attentionMapper.isAttention(cond);
    }


    /**
     * 获取关注列表
     *
     * @param username 用户名
     *
     * @return 关注列表
     */
    public List<String> getFollowees(String username) {
        return attentionMapper.selectFollowee(username);
    }

}
