package com.xeg.cores.base.utils;

import cn.hutool.core.date.DateUtil;

import java.time.*;
import java.util.Date;

/**
 * @author ningpeng
 * @description: 时间方法
 * @date 2021/6/3 15:43
 */
public class DateUtils {
    /**
     * 秒
     */
    public static final Integer SECOND = 60;

    /**
     * 毫秒
     */
    public static final Integer MILLISECOND = 1000;

    /**
     * 招工结束时间,分钟
     */
    public static final Integer RECRUIT_END_TIME_MINUTE = 2;

    /**
     * 获取N天后当天最大时间
     *
     * @param day
     * @return
     */

    public static Long getMaxDay(int day) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now().plusDays(day), LocalTime.MAX);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取N分钟后时间戳
     */
    public static Long offsetMinute(int minute) {
        return DateUtil.offsetMinute(new Date(), minute).getTime();
    }

    /**
     * 根据生日转换年龄1993-07-07
     *
     * @param ageStr
     * @return
     */
    public static int getUserAge(String ageStr) {
        return com.xeg.cores.base.utils.DateUtil.getYearDiff(com.xeg.cores.base.utils.DateUtil.localDateToDate(com.xeg.cores.base.utils.DateUtil.parseLocalDate(ageStr, "yyyy/MM/dd")), new Date());
    }

    /**
     * 获取当天零点时间戳
     *
     * @return timestamp
     */
    public static long getTodayMinTimestamp() {
        return localDateTimeToTimestamp(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
    }


    /**
     * 获取当天23:59:59时间戳
     *
     * @return timestamp
     */
    public static long getTodayMaxTimestamp() {
        return localDateTimeToTimestamp(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
    }


    /**
     * 日期转时间戳
     *
     * @param localDateTime 日期
     */
    public static long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    
}
