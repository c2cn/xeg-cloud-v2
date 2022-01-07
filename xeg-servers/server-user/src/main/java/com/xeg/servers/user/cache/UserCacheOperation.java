package com.xeg.servers.user.cache;

import cn.hutool.core.util.ObjectUtil;
import com.xeg.cores.base.cache.EmployerInfoCache;
import com.xeg.cores.base.cache.WorkerInfoCache;
import com.xeg.cores.base.utils.DateUtil;
import com.xeg.cores.base.utils.JsonUtils;
import com.xeg.cores.redis.cache.Cache;
import com.xeg.servers.user.bean.enums.UserTypeEnum;
import com.xeg.servers.user.bean.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

/**
 * @author ningpeng
 * @description: 用户信息缓存处理
 * @date 2021/4/27 16:35
 */
@Component
public class UserCacheOperation {
    /**
     * 用户登录token
     */
    public final static String USER_LOGIN_TOKEN = "user:login_token_{0}";

    /**
     * 用户登录token失效时间
     */
    public final static long USER_LOGIN_TOKEN_EXP_TIME = 3600;

    /**
     * 用户验证码缓存信息
     */
    public final static String USER_SMS_CODE = "user:sms_code_";

    /**
     * 用户验证码N秒内不可多次发送
     */
    public final static String USER_SMS_CODE_INTERVAL = "user:sms_code_interval_";
    /**
     * 用户验证码校验失败次数
     */
    public final static String USER_SMS_CODE_FAIL_TIMES = "user:sms_code_fail_times_";
    /**
     * 雇工缓存信息
     */
    public final static String WORKER_INFO = "user:worker_info";
    /**
     * 雇主缓存信息
     */
    public final static String EMPLOYER_INFO = "user:employer_info";
    /**
     * 用户登录失败次数
     */
    public final static String LOGIN_FAIL_TIMES = "user:login_fail_times_";
    /**
     * 用户登录失败次数
     */
    public final static String EDIT_PASSWORD_FAIL_TIMES = "user:edit_password_fail_times_";
    /**
     * 随机昵称
     */
    public final static String RANDOM_NICKNAME = "user:random_nickname";
    /**
     * 验证码失效时间
     */
    public final static long SMS_CODE_EXPIRED_TIME = 900;


    /**
     * 工人注册人数
     */
    public final static String WORKER_REGISTRY_NUM = "user:worker_registry_num_{0}";
    /**
     * 雇主注册人数
     */
    public final static String EMPLOYER_REGISTRY_NUM = "user:employer_registry_num_{0}";

    @Autowired
    private Cache cache;


    /**
     * @param token 令牌
     * @param vo    签证官 参数
     * @Description: 2021/11/04 18:42:52 写入用户令牌
     */
    public void writeUserToken(String token, UserLoginVO vo) {
        cache.set(MessageFormat.format(USER_LOGIN_TOKEN, token), vo, USER_LOGIN_TOKEN_EXP_TIME);
    }

    /**
     * @param token 令牌 参数
     * @Description: 2021/11/04 18:44:74 删除用户令牌
     */
    public void delUserToken(String token) {
        cache.del(MessageFormat.format(USER_LOGIN_TOKEN, token));
    }

    public List<String> getRandomNickname() {
        Object obj = cache.get(RANDOM_NICKNAME);
        if (ObjectUtil.isNull(obj)) {
            return null;
        }
        List<String> nicknameList;
        try {
            nicknameList = JsonUtils.toList(JsonUtils.toJson(obj), String.class);
        } catch (Exception e) {
            return null;
        }

        return nicknameList;
    }

    /**
     * 写入雇工基本信息
     *
     * @param userId
     * @param value
     */
    public void writeWorkerInfo(Long userId, String value) {
        cache.hset(WORKER_INFO, userId.toString(), value);
    }

    /**
     * 查询雇工基本信息
     *
     * @param userId
     * @return
     */
    public WorkerInfoCache readWorkerInfo(Long userId) {
        Object obj = cache.hget(WORKER_INFO, userId.toString());
        if (ObjectUtil.isNull(obj)) {
            return null;
        }
        WorkerInfoCache workerInfoCache;
        try {
            workerInfoCache = JsonUtils.toObject(obj.toString(), WorkerInfoCache.class);
        } catch (Exception e) {
            return null;
        }
        return workerInfoCache;
    }

    /**
     * 删除雇工基本信息
     */
    public void removeWorkerInfo(Long userId) {
        cache.hdel(WORKER_INFO, userId.toString());
    }

    /**
     * 写入雇主基本信息
     *
     * @param userId
     * @param value
     */
    public void writeEmployerInfo(Long userId, String value) {
        cache.hset(EMPLOYER_INFO, userId.toString(), value);
    }

    /**
     * 查询雇主基本信息
     *
     * @param userId
     * @return
     */
    public EmployerInfoCache readEmployerInfo(Long userId) {
        Object obj = cache.hget(EMPLOYER_INFO, userId.toString());
        if (ObjectUtil.isNull(obj)) {
            return null;
        }
        EmployerInfoCache employerInfoCache;
        try {
            employerInfoCache = JsonUtils.toObject(obj.toString(), EmployerInfoCache.class);
        } catch (Exception e) {
            return null;
        }
        return employerInfoCache;
    }

    /**
     * 删除雇主基本信息
     */
    public void removeEmployerInfo(Long userId) {
        cache.hdel(EMPLOYER_INFO, userId.toString());
    }


    /**
     * 写入验证码信息
     *
     * @param phone 用户手机号
     * @param code  验证码
     */
    public void writeSms(String phone, String code) {
        //900秒有效期 60秒内不可多次发送
        cache.set(USER_SMS_CODE + phone, code, SMS_CODE_EXPIRED_TIME);
        cache.set(USER_SMS_CODE_INTERVAL + phone, code, 60);
    }

    /**
     * 获取验证码信息
     *
     * @param phone 用户手机号
     */
    public String readSmsCode(String phone) {
        Object obj = cache.get(USER_SMS_CODE + phone);
        if (null == obj) {
            return "";
        }
        return obj.toString();
    }

    /**
     * 删除验证码
     *
     * @param phone 用户手机号
     */
    public void removeSmsCode(String phone) {
        cache.del(USER_SMS_CODE + phone);
    }

    /**
     * 获取验证码60秒内是否发送过
     *
     * @param phone 用户手机号
     */
    public boolean readSmsCodeInterval(String phone) {
        Object obj = cache.get(USER_SMS_CODE_INTERVAL + phone);
        if (null == obj) {
            return false;
        }
        return true;
    }

    /**
     * 查询验证码校验失败次数
     *
     * @param phone
     * @return
     */
    public Integer getSmsCodeFailTimes(String phone) {
        Object obj = cache.get(USER_SMS_CODE_FAIL_TIMES + phone);
        return ObjectUtil.isNotEmpty(obj) ? (Integer) obj : 0;
    }

    /**
     * 获取验证码失效时间
     *
     * @param phone
     * @param type  1 无验证码 2 已发送过验证码
     * @return
     */
    public Long getSmsCodeExpireTimes(String phone, int type) {
        if (type == 1) {
            return cache.getExpire(USER_SMS_CODE_FAIL_TIMES + phone);
        }
        return cache.getExpire(USER_SMS_CODE + phone);
    }

    /**
     * 保存验证码校验失败次数
     *
     * @param phone
     * @param num
     */
    public void setSmsCodeFailTimes(String phone, Integer num, Long time) {
        if (time <= 0) {
            // 默认900秒（验证码的失效时间）
            time = SMS_CODE_EXPIRED_TIME;
        }
        cache.set(USER_SMS_CODE_FAIL_TIMES + phone, num, time);
    }

    /**
     * 删除验证码校验失败次数
     *
     * @param phone
     */
    public void removeSmsCodeFailTimes(String phone) {
        cache.del(USER_SMS_CODE_FAIL_TIMES + phone);
    }

    /**
     * 获取登录失败次数
     *
     * @param phone
     * @return
     */
    public Integer getLoginFailTimes(String phone) {
        Object obj = cache.get(LOGIN_FAIL_TIMES + phone);
        return ObjectUtil.isNotEmpty(obj) ? (Integer) obj : 0;
    }

    /**
     * 设置登录失败次数
     *
     * @param id
     * @param times
     */
    public void setLoginFailTimes(Long id, int times) {
        // 获取距离当天23:59:59秒的时间差
        long expired = DateUtil.getTodayMaxTimestamp() - DateUtil.getTimestamp();
        cache.set(LOGIN_FAIL_TIMES + id, times, expired / 1000);
    }

    /**
     * 删除登录失败次数
     *
     * @param userId
     */
    public void removeLoginFailTimes(Long userId) {
        cache.del(LOGIN_FAIL_TIMES + userId);
    }

    /**
     * 查询修改密码失败次数
     *
     * @param id
     * @return
     */
    public Integer getEditPasswordFailTimes(Long id) {
        Object obj = cache.get(EDIT_PASSWORD_FAIL_TIMES + id);
        return ObjectUtil.isNotEmpty(obj) ? (Integer) obj : 0;
    }

    /**
     * 设置修改密码失败次数
     *
     * @param id
     * @param times
     * @return
     */
    public void setEditPasswordFailTimes(Long id, int times) {
        // 获取距离当天23:59:59秒的时间差
        long expired = DateUtil.getTodayMaxTimestamp() - DateUtil.getTimestamp();
        cache.set(EDIT_PASSWORD_FAIL_TIMES + id, times, expired / 1000);
    }

    /**
     * 删除修改密码失败次数
     *
     * @param id
     * @return
     */
    public void removeEditPasswordFailTimes(Long id) {
        cache.del(EDIT_PASSWORD_FAIL_TIMES + id);
    }


    /**
     * 删除修改密码失败次数
     *
     * @param userType
     * @param agentId  代理id
     */
    public void incrAgentRegistryNum(Integer userType, Long agentId) {
        String key = null;
        if (UserTypeEnum.WORKER.getValue().equals(userType)) {
            key = MessageFormat.format(WORKER_REGISTRY_NUM, agentId);
        }
        if (UserTypeEnum.EMPLOYER.getValue().equals(userType)) {
            key = MessageFormat.format(EMPLOYER_REGISTRY_NUM, agentId);
        }
        if (!ObjectUtil.isEmpty(key)) {
            cache.incr(key, 1);
        }
    }


    /**
     * 删除修改密码失败次数
     *
     * @param userType
     * @param agentId  代理id
     */
    public Long readAgentRegistryNum(Integer userType, Long agentId) {
        String key = null;
        if (UserTypeEnum.WORKER.getValue().equals(userType)) {
            key = MessageFormat.format(WORKER_REGISTRY_NUM, agentId);
        }
        if (UserTypeEnum.EMPLOYER.getValue().equals(userType)) {
            key = MessageFormat.format(EMPLOYER_REGISTRY_NUM, agentId);
        }
        if (!ObjectUtil.isEmpty(key)) {
            Object numObj = cache.get(key);
            if (!ObjectUtil.isEmpty(numObj)) {
                return Long.parseLong(String.valueOf(numObj));
            }
        }
        return 0L;
    }

}
