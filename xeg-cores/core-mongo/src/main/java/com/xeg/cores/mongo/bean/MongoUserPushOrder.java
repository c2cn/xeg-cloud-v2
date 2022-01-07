package com.xeg.cores.mongo.bean;

import com.xeg.cores.mongo.annotation.QueryField;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Zhang Zhongkun
 * @description: 派单服务已推送雇工订单记录
 * @date 2021/5/29 10:41
 */
@Document("userPushOrder")
@Data
public class MongoUserPushOrder implements Serializable {

    private static final long serialVersionUID = 503198595640021726L;

    /**
     * uuid 在mongo中生成唯一标示
     */
    @Id
    private String id;

    /**
     * 推送雇工id
     */
    @QueryField
    private Long userId;

    /**
     * 雇主订单编号
     */
    private String orderNo;

    /**
     * 订单状态 10招工中 50已取消
     */
    private Integer orderStatus;

    /**
     * 派单时间
     */
    private Long createTime;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 工作开始时间
     */
    @QueryField
    private Long workStartTime;

    /**
     * 工作结束时间
     */
    private Long workEndTime;

    /**
     * 我的工资
     */
    @QueryField
    private Long everyoneSalary;

    /**
     * 工作地点
     */
    private String workAddress;

    /**
     * 保证金状态 1.无保证金发单2.有保证金发单
     */
    private Integer depositType;

    /**
     * 结算方式
     */
    private String settlement;

    /**
     * 用工性别 0女 1男 2不限
     */
    private Integer workSex;

    /**
     * 用工年龄段 0不限  格式 18-60
     */
    private String workAge;

    /**
     * 议价类型 1定价单 2竞价单
     */

    private Integer offerType;
}
