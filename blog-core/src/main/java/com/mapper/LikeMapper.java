package com.mapper;

import com.bo.Like;

import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/29.
 */
public interface LikeMapper {


    /**
     * 查找收藏
     *
     * @param map 查询条件
     *
     * @return 收藏信息
     */
    Like selectLike(Map map);


    /**
     * 收藏列表
     *
     * @param map 查询条件
     *
     * @return 收藏列表
     */
    List<Like> selectLikeList(Map map);


    /**
     * 标签收藏列表
     *
     * @param map 查询条件
     *
     * @return 收藏列表
     */
    List<Like> selectLikeTagList(Map map);


    /**
     * 保存收藏
     *
     * @param like 收藏信息
     *
     * @return 是否保存成功
     */
    int replaceLike(Like like);


    /**
     * 取消收藏
     *
     * @param map 条件
     *
     * @return 删除结果
     */
    int deleteLike(Map<String, Object> map);


    /**
     * 收藏标签
     *
     * @param map 查询条件
     *
     * @return 标签
     */
    List<String> selectTags(Map<String, Object> map);
}
