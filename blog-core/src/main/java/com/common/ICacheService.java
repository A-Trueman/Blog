package com.common;

/**
 * Created by Lincg on 2017/5/11.
 */
public interface ICacheService {

    /**
     *
     * 删除指定keys的数据
     * @param keys 删除的keys
     *
     */
    void del(final String... keys);


    /**
     *
     * 判断该键值对是否存在
     * @param key 键值
     * @return 是否存在
     *
     */
    boolean exists(final String key);


    Object get(String key);


    /**
     * 读取缓存
     *
     * @param key 键值
     *
     * @return value值
     */
    Object getLong(final String key);


    /**
     * 写入缓存
     *
     * @param key 键名
     * @param value 键值
     *
     * @return 是否成功
     */
    boolean set(final String key, Object value);


    /**
     * 写入缓存
     *
     * @param key 键名
     * @param value 键值
     *
     * @return 是否成功
     */
    boolean setLong(final String key, Long value);

    /**
     * 写入缓存
     *
     * @param key 键名
     * @param value 键值
     * @param expireTime 有效时间
     *
     * @return  是否成功
     */
    boolean set(final String key, Object value, Long expireTime);


    /**
     *
     * @param key 键名
     *
     */
    public void increment(final String key);
}
