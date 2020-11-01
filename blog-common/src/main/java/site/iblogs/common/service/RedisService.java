package site.iblogs.common.service;

import java.util.concurrent.TimeUnit;

/**
 * Redis操作Service
 *
 * @author Liu Zhenyu on 3/15/2020
 */

public interface RedisService<T> {
    /**
     * 存储数据
     */
    void set(String key, T value);

    /**
     * 存储数据并设置过期时间,单位秒
     * */
    void set(String key, T value, long expire);

    /**
     * 获取数据
     */
    T get(String key);

    /**
     * 设置超期时间
     */
    Boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
