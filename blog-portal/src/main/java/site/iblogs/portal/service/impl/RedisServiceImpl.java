package site.iblogs.portal.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import site.iblogs.portal.service.RedisService;

import java.util.concurrent.TimeUnit;

/**
 * @author Liu Zhenyu on 3/15/2020
 */

@Service
public class RedisServiceImpl<T> implements RedisService<T> {

    private final RedisTemplate<String,T> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

    @Override
    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public T get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean expire(String key, long expire) {
        return redisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key,delta);
    }
}
