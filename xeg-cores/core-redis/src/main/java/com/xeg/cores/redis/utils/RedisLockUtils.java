package com.xeg.cores.redis.utils;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
	* @author xian
	* @date   2021年7月23日 上午9:42:52
	* @version v1.0.0
	* @Description	redis锁工具类
	* RedisLockUtils.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年7月23日 上午9:42:52       xian            v1.0.0           Created
 */
@Component
public class RedisLockUtils {
	// 锁名称
    public static final String LOCK_PREFIX = "{REDIS_LOCK}_";
    // 加锁失效时间，毫秒
    public static final int LOCK_EXPIRE = 3000; // ms
    
    @SuppressWarnings("rawtypes")
	@Autowired
    RedisTemplate redisTemplate;
 
   
    /**
    * @Title: lock  
    * @Description: 2021年7月23日 上午9:23:02 最终加强分布式锁
    * @param @param key
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean lock(String key){
        String lock = LOCK_PREFIX + key;
        // 利用lambda表达式
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {
            long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
            if (acquire) {
            	// 加锁成功
                return true;
            } else {
            	System.out.println("加锁失败。。。");
            	// 加锁失败，获取此锁的值
                byte[] value = connection.get(lock.getBytes());
                System.out.println("加锁失败。。。value = " + Long.parseLong(new String(value)));
                if (Objects.nonNull(value) && value.length > 0) {
                    long expireTime = Long.parseLong(new String(value));
                    System.out.println("expireTime = " + expireTime + ", currentTime = " + System.currentTimeMillis());
                     // 如果锁已经过期
                    if (expireTime < System.currentTimeMillis()) {
                    	System.out.println("重新加锁，防止死锁。。。");
                        // 重新加锁，防止死锁
                        byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                        
                        System.out.println("oldValue = " + Long.parseLong(new String(oldValue)) + ", currentTime = " + System.currentTimeMillis());
                        return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                    }
                } else {
                	// 没有获取到锁的值，可能刚被删除了，可以再次竞争获取
                }
            }
            
            return false;
        });
    }
 
    /**
    * @Title: delete  
    * @Description: 2021年7月23日 上午9:23:19 删除锁
    * @param @param key    参数  
    * @return void    返回类型  
    * @throws
     */
    @SuppressWarnings("unchecked")
	public void delete(String key) {
        redisTemplate.delete(key);
    }
    
    public void demo() {
    	RedisLockUtils redisLockUtils = new RedisLockUtils();
    	String key = "test";
    	boolean lock = redisLockUtils.lock(key);
        if (lock) {
            // 执行逻辑操作
        	redisLockUtils.delete(key);
        } else {
            // 设置失败次数计数器, 当到达5次时, 返回失败
            int failCount = 1;
            while(failCount <= 5){
                // 等待100ms重试
                try {
                    Thread.sleep(100l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (redisLockUtils.lock(key)){
                   // 执行逻辑操作
                	redisLockUtils.delete(key);
                }else{
                    failCount ++;
                }
            }
            throw new RuntimeException("现在创建的人太多了, 请稍等再试");
        }
	}
}
