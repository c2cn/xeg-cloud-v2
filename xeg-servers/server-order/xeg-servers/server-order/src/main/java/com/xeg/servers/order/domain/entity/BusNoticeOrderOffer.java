package com.xeg.servers.order.domain.entity;

import java.math.BigDecimal;
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
 * 短工大厅订单议价表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order_offer")
@ApiModel(value="BusNoticeOrderOffer对象", description="短工大厅订单议价表")
public class BusNoticeOrderOffer implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "工人id")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "议价金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "议价内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "议价状态 1待处理 2成功 3失败 4正在缴纳保证金")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "失效状态 1已拒绝 2抢单成功 3超时未选 4已被其他雇主选择  5雇主修改订单")
    @TableField("invalid_status")
    private Integer invalidStatus;

    @ApiModelProperty(value = "锁定状态 0未锁定 1已锁定")
    @TableField("locked_status")
    private Boolean lockedStatus;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "待遇")
    @TableField("welfare")
    private String welfare;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
