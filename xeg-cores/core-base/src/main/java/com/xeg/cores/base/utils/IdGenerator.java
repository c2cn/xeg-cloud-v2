package com.xeg.cores.base.utils;

import java.util.Date;
import java.util.Random;

/**
 * @Description ID生成器
 * @Author xulp
 * @Date 2020/11/18 15:31
 */
public class IdGenerator {
    /**
     * 最近的时间戳 单位：s
     */
    private long lastTimestamp = 0;
    /**
     * 业务模块ID
     */
    private final String module;
    /**
     * 业务模块类型
     */
    private final String type;
    /**
     * 0，并发控制
     */
    private long sequence = 0L;
    /**
     * 序列号的最大值
     */
    private final int sequenceMax = 999999;


    public IdGenerator(String module, String type) {
        this.module = module;
        this.type = type;
    }

    private static IdGenerator instance;

    public static IdGenerator getInstance(String module, String type) {
        if (instance == null) {
            instance = new IdGenerator(module, type);
        }
        return instance;
    }

    /**
     * 获取id号
     *
     * @param module 业务模块ID
     * @param type   业务模块类型
     */
    public static String getId(String module, String type) {
        IdGenerator id = IdGenerator.getInstance(module, type);
        String nextId = id.nextId();
        return nextId;
    }


    /**
     * 获取流水号
     *
     * @param type 10支付 20退款 30服务费
     */
    public static String getSerialNo(String type) {
        IdGenerator id = IdGenerator.getInstance("", type);
        return id.nextId();
    }

    /***
     * 获取订单号
     * @param orderSource 订单来源 1滴滴单 2召集单 3常用单 4公告大厅 5直播间 6技工单 7客服代发
     * @param offerType 议价类型 0竞价单 1定价单
     * @param workDivisionCode 地区码
     * @param phone 电话号
     */
    public static String getOrderNo(int orderSource, int offerType, String workDivisionCode, String phone) {
        // 获取当前日期的 月 - 日
        String date = DateUtil.getCurrentDateTime("MMdd");
        // 获取手机号后四位
        String cutPhone = phone.substring(7);
        // 四位随机数
        String random = getRandomNum(9999, 4);
        // 返回拼接字符串
        StringBuilder sb = new StringBuilder(orderSource).append(offerType).append(workDivisionCode).
                append(date).append(cutPhone).append(random);
        return sb.toString();
    }


    /**
     * 生成id号
     */
    public synchronized String nextId() {
        Date now = new Date();
        String time = DateUtil.formatDatetime(now, "yyyyMMddHHmmss");
        long timestamp = now.getTime() / 1000L;
        if (this.lastTimestamp == timestamp) {
            // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环);
            // 对新的timestamp，sequence从0开始
            this.sequence = this.sequence + 1 % this.sequenceMax;
            if (this.sequence == 0) {
                // 重新生成timestamp
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        this.lastTimestamp = timestamp;
        StringBuilder sb = new StringBuilder(module).append(type).append(time).append(leftPad(sequence, 6));
        return sb.toString();
    }

    /**
     * 补码
     *
     * @param i
     * @param n
     */
    private String leftPad(long i, int n) {
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder();
        int c = n - s.length();
        c = c < 0 ? 0 : c;
        for (int t = 0; t < c; t++) {
            sb.append("0");
        }
        return sb.append(s).toString();
    }

    /**
     * 等待下一个秒的到来, 保证返回的秒数在参数lastTimestamp之后
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis() / 1000L;
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis() / 1000L;
        }
        return timestamp;
    }


    /**
     * 获取指定位数的随机数
     *
     * @param randomMax 随机数最大值
     * @param coverNum  补位数
     */
    private static String getRandomNum(int randomMax, int coverNum) {
        Random ran = new Random();
        int num = ran.nextInt(randomMax);
        return String.format("%0" + coverNum + "d", num);
    }

}



