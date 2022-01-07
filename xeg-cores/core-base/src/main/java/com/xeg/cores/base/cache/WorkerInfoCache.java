package com.xeg.cores.base.cache;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: 缓存的雇工基本信息
 * @date 2021/6/9 16:55
 */
@Data
public class WorkerInfoCache implements Serializable {
    /**
     * 此处新增字段后,将user:worker_info 缓存整个删除
     */

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生年月
     */
    private String birthday;

    /**
     * 信用分
     */
    private Integer creditScore;

    /**
     * 注册地区
     */
    private String areaCode;

    /**
     * 钱包编号
     */
    private Long walletId;

    /**
     * 钱包状态 1 未开通 2已开通
     */
    private Integer walletStatus;

    /**
     * 上级代理Id
     */
    private Long agentId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 好评数
     */
    private Integer goodEvaluateNum;

    /**
     * 中差评数
     */
    private Integer generalEvaluateNum;

    /**
     * 完成订单数量
     */
    private Integer finishOrderNum;

    /**
     * 累计接单数量
     */
    private Integer receiveOrderTotalNum;

    /**
     * 实名状态 1 未实名 2已实名
     */
    private Integer realNameStatus;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 腾讯im注册的id
     */
    private Long imId;
}
