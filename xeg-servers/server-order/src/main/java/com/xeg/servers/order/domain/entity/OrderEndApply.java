package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
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
	* @date   2021年11月4日 下午5:38:48
	* @version v1.0.0
	* @Description	订单结束申请
	* OrderEndApply.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:38:48       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_end_apply")
@ApiModel(value="OrderEndApply对象", description="订单结束申请")
public class OrderEndApply implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号(仅短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单来源 1劳务单 2召集单 3常用单 4短工大厅 5直播间 6技工单")
    @TableField("order_source")
    private Boolean orderSource;

    @ApiModelProperty(value = "申请来源 1工人 2雇主 判断同意/拒绝")
    @TableField("source")
    private Integer source;

    @ApiModelProperty(value = "用户id")
    @TableField("from_uid")
    private Integer fromUid;

    @ApiModelProperty(value = "被推送人id")
    @TableField("to_uid")
    private Integer toUid;

    @ApiModelProperty(value = "申请状态 1未处理 2已接受 3已拒绝 4已超时")
    @TableField("accept_status")
    private Integer acceptStatus;

    @ApiModelProperty(value = "投诉状态按钮显隐 0 隐藏 1 显示")
    @TableField("complain_button")
    private Integer complainButton;

    @ApiModelProperty(value = "是否投诉0未投诉 1已投诉")
    @TableField("is_complain")
    private Integer isComplain;

    @ApiModelProperty(value = "申请时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "申请完成订单拒绝时间")
    @TableField("rejected_time")
    private LocalDateTime rejectedTime;

    @ApiModelProperty(value = "工人id")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "拒绝次数")
    @TableField("reject_num")
    private Integer rejectNum;

    @ApiModelProperty(value = "拒绝人用户id")
    @TableField("reject_user_id")
    private String rejectUserId;

    @ApiModelProperty(value = "同意人用户")
    @TableField("accept_user_id")
    private String acceptUserId;

    @ApiModelProperty(value = "投诉人用户")
    @TableField("complaint_user_id")
    private String complaintUserId;

    @ApiModelProperty(value = "雇主id")
    @TableField("employer_id")
    private Integer employerId;


}
