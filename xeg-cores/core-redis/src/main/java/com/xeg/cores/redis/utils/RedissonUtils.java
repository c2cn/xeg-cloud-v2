package com.xeg.cores.redis.utils;

import com.xeg.cores.base.constant.StringCommonConstant;
import org.redisson.api.RLock;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ningpeng
 * @Description redission 工具类
 */
@Component
public class RedissonUtils {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 加锁
     *
     * @param lockName
     * @param WAIT_TIME
     * @param TIME_OUT_SECOND
     * @return
     */
    public boolean afterPropertiesSet(String lockName, Integer WAIT_TIME, Integer TIME_OUT_SECOND) {
        try {
            String key = StringCommonConstant.LOCK_TITLE + lockName;
            RLock mylock = redissonClient.getLock(key);
            //lock提供带timeout参数，timeout结束强制解锁，防止死锁
            //先尝试在超时时间内获取锁，如果没有获取到，此时如果等待时间还有剩余进入循环不断取尝试获取锁 直到时间结束退出  循环中是订阅，时间结束取消订阅
            return mylock.tryLock(WAIT_TIME, TIME_OUT_SECOND, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param lockName
     */
    public void release(String lockName) {
        String key = StringCommonConstant.LOCK_TITLE + lockName;
        RLock lock = redissonClient.getLock(key);
        if (lock.isLocked()) {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    /**
     * 放入延时队列
     *
     * @param key   redis key
     * @param obj   延时队列中存储的对象
     * @param score 延时队列取出时间 时间戳 毫秒
     */
    public void pushDelayQueue(String key, Object obj, double score) {
        RScoredSortedSet<Object> set = redissonClient.getScoredSortedSet(key);
        set.add(score, obj);
    }

    /**
     * 公共方法-获取延时队列第一个值
     *
     * @param key      redis key
     * @param interval 提前N 毫秒取出延时队列中Object
     * @return Object 延时队列中的对象
     */
    public Object getQueueFirstValue(String key, long interval) {
        Object obj = null;
        RScoredSortedSet<Object> set = redissonClient.getScoredSortedSet(key);
        if (set.size() > 0) {
            double score = set.firstScore();
            long time = System.currentTimeMillis();
            long surplus = (long) (score - time);
            if (surplus < interval) {
                // 提前1秒 当score 等于当前时间戳时   该对象才可被取出
                obj = set.first();
                //删除对象
                set.remove(obj);
            }
        }
        return obj;
    }

    /**
     * zset 增加分数
     */
    public void addScore(String key, Object obj, double score) {
        RScoredSortedSet<Object> set = redissonClient.getScoredSortedSet(key);
        set.addScore(obj, score);
    }

    /**
     * zset 删除对象
     */
    public void removeObject(String key, Object obj) {
        RScoredSortedSet<Object> set = redissonClient.getScoredSortedSet(key);
        set.remove(obj);
    }
}
