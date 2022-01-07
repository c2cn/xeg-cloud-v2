package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
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
	* @date   2021年11月4日 下午5:38:58
	* @version v1.0.0
	* @Description	申请完成订单拒绝记录
	* OrderEndRejectRecord.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:38:58       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_end_reject_record")
@ApiModel(value="OrderEndRejectRecord对象", description="申请完成订单拒绝记录")
public class OrderEndRejectRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "申请完成订单id")
    @TableField("applyId")
    private Integer applyId;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
