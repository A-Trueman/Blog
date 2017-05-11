package com.common.impl;

import com.common.ICacheService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lincg on 2017/5/11.
 */
public final class CacheService implements ICacheService{


    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 删除指定keys的数据
     *
     * @param keys 删除的keys
     *
     */
    @Override
    public void del(final String... keys) {
        for (String key : keys) {
            if (exists(key)) {
                redisTemplate.delete(key);
            }
        }
    }


    /**
     * 判断该键值对是否存在
     *
     * @param key 键值
     *
     * @return 是否存在
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 读取缓存
     *
     * @param key 键值
     *
     * @return value值
     */
    @Override
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 写入缓存
     *
     * @param key 键名
     * @param value 键值
     *
     * @return 是否成功
     */
    @Override
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 写入缓存
     *
     * @param key 键名
     * @param value 键值
     * @param expireTime 有效时间
     *
     * @return  是否成功
     */
    @Override
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;

        try {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            result =true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
