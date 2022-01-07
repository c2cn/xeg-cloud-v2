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
	* @date   2021年11月4日 下午5:35:05
	* @version v1.0.0
	* @Description	短工大厅订单基本信息表
	* NoticeOrder.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:35:05       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order")
@ApiModel(value="BusNoticeOrder对象", description="短工大厅订单基本信息表")
public class NoticeOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "0 竞价单 1 定价单")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "雇主id")
    @TableField("employer_id")
    private Integer employerId;

    @ApiModelProperty(value = "订单来源 4公告大厅")
    @TableField("order_source")
    private Boolean orderSource;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "人数")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "计薪方式 1按时薪 2按人 3按总价")
    @TableField("money_mode")
    private Integer moneyMode;

    @ApiModelProperty(value = "工人时薪")
    @TableField("hour_money")
    private BigDecimal hourMoney;

    @ApiModelProperty(value = "人均工资")
    @TableField("per_money")
    private BigDecimal perMoney;

    @ApiModelProperty(value = "总计工资")
    @TableField("total_money")
    private BigDecimal totalMoney;

    @ApiModelProperty(value = "用工职位")
    @TableField("position")
    private String position;

    @ApiModelProperty(value = "工作内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "浏览量")
    @TableField("page_view")
    private Integer pageView;

    @ApiModelProperty(value = "公布时长 单位:小时")
    @TableField("notice_duration")
    private Double noticeDuration;

    @ApiModelProperty(value = "订单关闭关闭时间")
    @TableField("close_time")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "保证金金额")
    @TableField("bond_money")
    private BigDecimal bondMoney;

    @ApiModelProperty(value = "订单状态 0未支付 30招工中 50已结束(主动结束/自动结束) 90已取消(待支付订单自动取消/主动取消） 100已成单 110订单已完成（全部工人同意申请完成订单）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "结束状态 0未结束 1已结束")
    @TableField("end_status")
    private Integer endStatus;

    @ApiModelProperty(value = "失败类型 0未失败 1无人接单  2人足超时未选 3人不足超时未选 4管理端结束")
    @TableField("error_status")
    private Integer errorStatus;

    @ApiModelProperty(value = "评价状态 0未评价 1已评价")
    @TableField("evaluate_status")
    private Integer evaluateStatus;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "查看时间（雇主查看此订单的时间，用于几分钟前在线）")
    @TableField("check_time")
    private LocalDateTime checkTime;

    @ApiModelProperty(value = "多少人正在查看")
    @TableField("worker_view")
    private Integer workerView;

    @ApiModelProperty(value = "是否管理端结束（0-否，1-是）")
    @TableField("is_admin_end")
    private Boolean adminEnd;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否主动结束 Y是  N否")
    @TableField("active_click")
    private String activeClick;

    @ApiModelProperty(value = "是否保证金发布 Y是 N否")
    @TableField("margin")
    private String margin;

    @ApiModelProperty(value = "编辑重发的次数")
    @TableField("num")
    private Integer num;

    @ApiModelProperty(value = "成单时间")
    @TableField("success_time")
    private LocalDateTime successTime;

    @ApiModelProperty(value = "json串")
    @TableField("json")
    private String json;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;


}
