package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
	* @author xian
	* @date   2021年11月4日 下午5:41:28
	* @version v1.0.0
	* @Description	分成快照表
	* Settlement.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:41:28       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_settlement")
@ApiModel(value="Settlement对象", description="分成快照表")
public class Settlement implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类型 1.保证金 2.畅聊费")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "订单号")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "保证金金额")
    @TableField("bond_money")
    private BigDecimal bondMoney;

    @ApiModelProperty(value = "退还金额")
    @TableField("bond_refund")
    private BigDecimal bondRefund;

    @ApiModelProperty(value = "平台服务费")
    @TableField("platform_charge")
    private BigDecimal platformCharge;

    @ApiModelProperty(value = "平台Id")
    @TableField("platform_id")
    private Integer platformId;

    @ApiModelProperty(value = "代理服务费")
    @TableField("agent_charge")
    private BigDecimal agentCharge;

    @ApiModelProperty(value = "代理Id")
    @TableField("agent_id")
    private Integer agentId;

    @ApiModelProperty(value = "虚拟老板服务费")
    @TableField("boss_charge")
    private BigDecimal bossCharge;

    @ApiModelProperty(value = "虚拟市场老板Id")
    @TableField("boss_id")
    private Integer bossId;

    @ApiModelProperty(value = "结算时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态 0 未结算 1核对结算 2支付结算")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "支付单号")
    @TableField("pay_code")
    private String payCode;


}
