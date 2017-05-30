package com.mapper;

import com.bo.Attention;

import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/30.
 */
public interface AttentionMapper {

    /**
     * 添加关注
     *
     * @param attention 关注信息
     *
     * @return 结果
     */
    int replaceAttention(Attention attention);


    /**
     * 是否关注
     *
     * @param map 查询条件
     *
     * @return 关注结果
     */
    int isAttention(Map<String, Object> map);


    List<String> selectFollowee(String username);


    int deleteAttention(Map<String, Object> map);
}
