package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
	* @date   2021年11月4日 下午5:36:16
	* @version v1.0.0
	* @Description	短工大厅电话购买记录
	* NoticeOrderPhone.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:36:16       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order_phone")
@ApiModel(value="BusNoticeOrderPhone对象", description="短工大厅电话购买记录")
public class NoticeOrderPhone implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "购买人id")
      @TableId("party_a")
    private Integer partyA;

    @ApiModelProperty(value = "订单号码")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "被购买人id")
    @TableField("party_b")
    private Integer partyB;

    @ApiModelProperty(value = "时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付订单号")
    @TableField("pay_code")
    private String payCode;

    @ApiModelProperty(value = "1工人 2雇主")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value = "支付方式1 微信 2支付宝")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty(value = "支付金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "0未删除。1已删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
