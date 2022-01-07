package com.xeg.servers.user.domain.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 工人表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_worker")
@ApiModel(value = "WorkerInfo对象", description = "工人表")
public class WorkerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人表id")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户信息表id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "用户昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "信用分")
    @TableField("credit_score")
    private Integer creditScore;

    @ApiModelProperty(value = "纬度")
    @TableField("lat")
    private BigDecimal lat;

    @ApiModelProperty(value = "经度")
    @TableField("lng")
    private BigDecimal lng;

    @ApiModelProperty(value = "城市(省市区)")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "接单状态 0停止接单 1进入接单状态")
    @TableField("receipt_state")
    private Integer receiptState;

    @ApiModelProperty(value = "头像")
    @TableField("head_img")
    private String headImg;

    @ApiModelProperty(value = "接单范围(1异地单 2技能单 3劳务单 4家政单 5兼职 6其他)")
    @TableField("order_scope")
    private String orderScope;

    @ApiModelProperty(value = "0正常1待观察用户")
    @TableField("observed_flg")
    private Integer observedFlg;

    @ApiModelProperty(value = "真实姓名")
    @TableField("true_name")
    private String trueName;

    @ApiModelProperty(value = "接单总数")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "订单总金额")
    @TableField("order_total")
    private BigDecimal orderTotal;

    @ApiModelProperty(value = "派单总数")
    @TableField("dispatch_num")
    private Integer dispatchNum;

    @ApiModelProperty(value = "福利待遇")
    @TableField("welfare")
    private String welfare;

    @ApiModelProperty(value = "最后一单下单时间")
    @TableField("last_order_time")
    private Long lastOrderTime;

    @ApiModelProperty(value = "状态0->正常 1->预冻结 2->冻结")
    @TableField("frozen_status")
    private Integer frozenStatus;

    @ApiModelProperty(value = "状态位 0正常 1删除")
    @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;


}
