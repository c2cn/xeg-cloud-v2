package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
	* @author xian
	* @date   2021年11月4日 下午5:39:47
	* @version v1.0.0
	* @Description	工人议价信息表
	* OrderOffer.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:39:47       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_offer")
@ApiModel(value="OrderOffer对象", description="工人议价信息表")
public class OrderOffer implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "伪工头编号 0没有工头 其它 同编号为同一伪工头组内")
    @TableField("worker_pid")
    private Integer workerPid;

    @ApiModelProperty(value = "工人编号")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "议价订单类型：1.滴滴单2.招工大厅")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty(value = "雇主订单编号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "雇主订单编号")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "议价状态 1已议价 2议价成功 3议价失败")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "失败类型 1抢单成功 2工作时间冲突 3补缴保证金超时")
    @TableField("error_status")
    private Integer errorStatus;

    @ApiModelProperty(value = "锁定状态 0未锁定 1已锁定")
    @TableField("locked_status")
    private Integer lockedStatus;

    @ApiModelProperty(value = "议价金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "议价内容")
    @TableField("offer_welfare")
    private String offerWelfare;

    @ApiModelProperty(value = "议价时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "议价结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
