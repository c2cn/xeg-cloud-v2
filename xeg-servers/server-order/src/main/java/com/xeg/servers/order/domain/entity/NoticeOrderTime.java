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
	* @date   2021年11月4日 下午5:36:55
	* @version v1.0.0
	* @Description	短工大厅雇主订单每天工作时间
	* NoticeOrderTime.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:36:55       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order_time")
@ApiModel(value="BusNoticeOrderTime对象", description="短工大厅雇主订单每天工作时间")
public class NoticeOrderTime implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号(仅短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "雇主订单编号")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "当天开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "当天结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "休息状态 0不可休息 1可休息")
    @TableField("rest_status")
    private Integer restStatus;

    @ApiModelProperty(value = "休息时长")
    @TableField("rest_duration")
    private Integer restDuration;

    @ApiModelProperty(value = "预计完工状态 0不开启 1开启")
    @TableField("expect_completion_status")
    private Integer expectCompletionStatus;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
