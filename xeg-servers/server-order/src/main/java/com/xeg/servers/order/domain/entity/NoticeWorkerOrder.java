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
	* @date   2021年11月4日 下午5:37:51
	* @version v1.0.0
	* @Description	短工大厅工人订单表
	* NoticeWorkerOrder.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:37:51       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_worker_order")
@ApiModel(value="BusNoticeWorkerOrder对象", description="短工大厅工人订单表")
public class NoticeWorkerOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "雇主订单编号(暂时短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "工人id")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "接单类型  2议价接单 1直接接单")
    @TableField("get_type")
    private Integer getType;

    @ApiModelProperty(value = "订单价格(直接接单填订单原价 议价接单填议价价格)")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "结束状态 0未结束 1已结束")
    @TableField("end_state")
    private Integer endState;

    @ApiModelProperty(value = "订单创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "订单结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "评价状态 0未评价 1已评价")
    @TableField("evaluate_state")
    private Integer evaluateState;

    @ApiModelProperty(value = "是否被拉入 0否 1是")
    @TableField("is_invite")
    private Integer isInvite;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "是否管理端结束（0-否，1-是）")
    @TableField("is_admin_end")
    private Boolean adminEnd;

    @ApiModelProperty(value = "待遇")
    @TableField("welfare")
    private String welfare;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "修改人ID")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
