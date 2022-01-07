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
	* @date   2021年11月4日 下午5:34:53
	* @version v1.0.0
	* @Description	工人直播间排队信息
	* LiveWorker.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:34:53       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_live_worker")
@ApiModel(value="LiveWorker对象", description="工人直播间排队信息")
public class LiveWorker implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "直播间编号")
    @TableField("live_id")
    private Integer liveId;

    @ApiModelProperty(value = "订单编号")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "0排队中   10上麦中")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "异常状态 10 主动下麦 20未被选择 30订单结束")
    @TableField("exception_status")
    private Integer exceptionStatus;

    @ApiModelProperty(value = "0未成单  1 已成单")
    @TableField("order_status")
    private Integer orderStatus;

    @ApiModelProperty(value = "工人编号")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "议价")
    @TableField("offer_money")
    private BigDecimal offerMoney;

    @ApiModelProperty(value = "报价自荐金额")
    @TableField("oneself_offer_money")
    private BigDecimal oneselfOfferMoney;

    @ApiModelProperty(value = "自荐报价状态 0 未自荐 1已自荐")
    @TableField("oneself_offer_status")
    private Integer oneselfOfferStatus;

    @ApiModelProperty(value = "报价自荐支付时间")
    @TableField("oneself_offer_paytime")
    private LocalDateTime oneselfOfferPaytime;

    @ApiModelProperty(value = "创建时间（排队时间）")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
