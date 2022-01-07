package com.xeg.cores.redis.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 缓存接口
 *
 * @author kingapex
 */
@SuppressWarnings({"rawtypes"})
public interface Cache<T> {

    /**
     * Get an item from the cache, nontransactionally
     *
     * @param key
     * @return the cached object or <tt>null</tt>
     */
    T get(Object key);

    /**
     * multiGet
     *
     * @param keys 要查询的key集合
     * @return
     */
    List multiGet(Collection keys);

    /**
     * 批量set
     *
     * @param map
     */
    void multiSet(Map map);

    /**
     * 批量删除
     *
     * @param keys 要删除的key集合
     */
    void multiDel(Collection keys);

    /**
     * Add an item to the cache, nontransactionally, with failfast semantics
     *
     * @param key
     * @param value
     */
    void put(Object key, T value);

    /**
     * 往缓存中写入内容
     *
     * @param key
     * @param value
     * @param exp   超时时间，单位为秒
     */
    void put(Object key, T value, int exp);

    /**
     * 删除
     *
     * @param key
     */
    void remove(Object key);

    /**
     * 删除
     *
     * @param key
     */
    void vagueDel(Object key);

    /**
     * Clear the cache
     */
    void clear();

    /**
     * 往缓存中写入内容
     *
     * @param key       缓存key
     * @param hashKey   缓存中hashKey
     * @param hashValue hash值
     */
    void putHash(Object key, Object hashKey, Object hashValue);

    /**
     * 玩缓存中写入内容
     *
     * @param key
     * @param map
     */
    void putAllHash(Object key, Map map);

    /**
     * 玩缓存中写入内容
     *
     * @param key
     * @param map
     * @param exp 过期时间
     */
    void putAllHash(Object key, Map map, int exp);

    /**
     * 读取缓存值
     *
     * @param key
     * @param hashKey
     * @return
     */
    T getHash(Object key, Object hashKey);

    /**
     * 读取缓存值
     *
     * @param key
     * @return
     */
    Map<Object, Object> getHash(Object key);

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    boolean expire(String key, long time);

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    long getExpire(String key);

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    void del(String... key);

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    Object get(String key);

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    boolean set(String key, Object value);

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    boolean set(String key, Object value, long time);

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    long incr(String key, long delta);

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    long decr(String key, long delta);

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    Object hget(String key, String item);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    boolean hset(String key, String item, Object value);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    boolean hset(String key, String item, Object value, long time);

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    void hdel(String key, Object... item);

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    Set<Object> sGet(String key);

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSet(String key, Object... values);

}
