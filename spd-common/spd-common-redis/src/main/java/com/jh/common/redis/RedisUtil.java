package com.jh.common.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_DICT = 60 * 60 * 3;

    /**
     * 3分支过期时长，单位：秒
     */
    public final static long THREE_MINUTES_EXPIRE = 60 * 3;
    /**
     * 10分钟期时长，单位：秒
     */
    public final static long TEN_MINUTES_EXPIRE = 60 * 10;

    /**
     * 1分钟期时长，单位：毫秒
     */
    public final static long ONE_MINUTE_EXPIRE = 60 * 1000;

    /**
     * 6分钟期时长，单位：毫秒
     */
    public final static long SIX_MINUTE_EXPIRE = 6 * 60 * 1000;
    /**
     * 10分钟期时长，单位：毫秒
     */
    public final static long TEN_MINUTE_EXPIRE_MS = 10 * 60 * 1000;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;


    public void setObject(String key, Object value) {
        setObject(key, value, DEFAULT_EXPIRE);
    }

    public void setObjectNoExpire(String key, Object value) {
        setObject(key, value, NOT_EXPIRE);
    }

    public void setObject(String key, Object value, long expire) {
        if (expire != NOT_EXPIRE) {
            valueOperations.set(key, toJson(value), expire, TimeUnit.SECONDS);
        } else {
            valueOperations.set(key, toJson(value));
        }
    }

    /**
     * @Description 该方法，存储到redis后可以立即查到，但会破坏 @Transactional 标签，异常后redis不会自动回滚，谨慎使用
     **/
    public void setObjectNoTransaction(String key, Object value, long expire) {
        redisTemplate.multi();
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        redisTemplate.exec();
    }

    public String getStr(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String getStr(String key) {
        return getStr(key, NOT_EXPIRE);
    }

    public <T> T getObject(String key, Class<T> clazz) {
        return getObject(key, clazz, NOT_EXPIRE);
    }

    public <T> T getObject(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJsonToObject(value, clazz);
    }


    public <T> List<T> getStrToList(String key, Class<T> clazz) {
        String value = valueOperations.get(key);
        return value == null ? null : fromJsonToList(value, clazz);
    }

    // List操作
    public void setList(String key, List value) {
        setList(key, value, DEFAULT_EXPIRE);
    }

    public void setList(String key, List value, long expire) {
        if (value == null || value.isEmpty()) {
            return;
        }
        listOperations.leftPushAll(key, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        return getList(key, clazz, NOT_EXPIRE);
    }

    public <T> List<T> getList(String key, Class<T> clazz, long expire) {
        List<Object> list = listOperations.range(key, 0, -1);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return (List<T>) list;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float
                || object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJsonToObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    public void setObjectMap(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public void setAllObjectMap(String key, Map map) {
        //redisTemplate.multi();
        redisTemplate.opsForHash().putAll(key, map);
        //redisTemplate.exec();
    }

    public Object getObjectMap(String key, String hashKey) {
        Object object = redisTemplate.opsForHash().get(key, hashKey);
        return object;
    }

    public Long getObjectMapSize(String key) {
        Long size = redisTemplate.opsForHash().size(key);
        return size;
    }

    public void deleteMapKey(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    public List getMapAllObject(String key) {
        List list = redisTemplate.opsForHash().values(key);
        return list;
    }

    /**
     * @param key
     * @param val     值
     * @param timeout 失效时间
     * @param days    时间单位
     */
    public void setObject(String key, int val, long timeout, TimeUnit days) {
        redisTemplate.opsForValue().set(key, val, timeout, days);
    }

    /**
     * 自增+1
     *
     * @param key
     */
    public void increment(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    /**
     * 自增 + i
     *
     * @param key
     * @param i
     */
    public void increment(String key, int i) {
        redisTemplate.opsForValue().increment(key, i);
    }

    public Integer getObject(String key) {
        return (Integer) redisTemplate.opsForValue().get(key);
    }

    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取锁
     *
     * @param key
     * @param expire 毫秒
     * @return 获取锁是否成功
     */
    public boolean getLock(String key, long expire) {
        logger.info("redis添加锁, key={}, expire={}", key, expire);
        long expireAt = System.currentTimeMillis() + expire;
        boolean bl = redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(expireAt));
        if (bl) {
            redisTemplate.expire(key, expire, TimeUnit.MILLISECONDS);
            return true;
        }
        return false;
    }

    /**
     * 释放锁
     */
    public void unLock(String key) {
        logger.info("redis解锁, key={}", key);
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error("解锁失败", e);
        }

    }

    public void sadd(String key, Set<String> set) {
        setOperations.add(key, set);

    }

    /**
     * 返回差集(A-B)
     *
     * @param keyA
     * @param keyB
     * @return
     */
    public Set<Object> sdiff(String keyA, String keyB) {
        return setOperations.difference(keyA, keyB);
    }

    /**
     * 返回交集(A∩B)
     *
     * @param keyA
     * @param keyB
     * @return
     */
    public Set<Object> sInter(String keyA, String keyB) {
        return setOperations.intersect(keyA, keyB);
    }

    /**
     * 返回并集(A∩B)
     *
     * @param keyA
     * @param keyB
     * @return
     */
    public Set<Object> sUnion(String keyA, String keyB) {
        return setOperations.union(keyA, keyB);
    }

}
