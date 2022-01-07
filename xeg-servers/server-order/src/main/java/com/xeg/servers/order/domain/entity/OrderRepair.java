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
	* @date   2021年11月4日 下午5:40:21
	* @version v1.0.0
	* @Description	订单补救措施表
	* OrderRepair.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:40:21       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_repair")
@ApiModel(value="OrderRepair对象", description="订单补救措施表")
public class OrderRepair implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "重新编辑次数")
    @TableField("edit_num")
    private Integer editNum;

    @ApiModelProperty(value = "转滴滴次数")
    @TableField("didi_num")
    private Integer didiNum;

    @ApiModelProperty(value = "转议价次数")
    @TableField("offer_num")
    private Integer offerNum;

    @ApiModelProperty(value = "转委托次数")
    @TableField("entrust_num")
    private Integer entrustNum;

    @ApiModelProperty(value = "使用状态 1未使用 2已使用 3已结束 4已超时")
    @TableField("use_status")
    private Integer useStatus;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
