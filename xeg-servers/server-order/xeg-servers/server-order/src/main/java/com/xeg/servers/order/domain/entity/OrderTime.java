package com.xeg.servers.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 雇主订单每天工作时间
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_time")
@ApiModel(value="OrderTime对象", description="雇主订单每天工作时间")
public class OrderTime implements Serializable {

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

    @ApiModelProperty(value = "特殊开工时间，0否，1是，默认为0，主要用来前端显示（马上开工（xx点前））")
    @TableField("special_start_time")
    private Boolean specialStartTime;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
