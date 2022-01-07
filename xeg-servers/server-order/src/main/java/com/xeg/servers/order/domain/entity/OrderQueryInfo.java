package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
	* @author xian
	* @date   2021年11月4日 下午5:38:02
	* @version v1.0.0
	* @Description	订单查询信息表
	* Order.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:38:02       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order")
@ApiModel(value="Order对象", description="订单查询信息表")
public class OrderQueryInfo implements Serializable {
    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "雇主id")
    @TableField("employer_id")
    private Integer employerId;

    @ApiModelProperty(value = "直播间id")
    @TableField("live_id")
    private Integer liveId;
    
    @ApiModelProperty(value = "订单成单类型：1-人工 2-自动")
    @TableField("order_form_type")
    private Boolean orderFormType;
    
    @ApiModelProperty(value = "订单来源 1劳务单 2召集单 3常用单 4短工大厅 5直播间 6技工单")
    @TableField("order_source")
    private Integer orderSource;

    @ApiModelProperty(value = "订单类型 1定价单 2竞价单")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "人数")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "时薪")
    @TableField("hourly_wage")
    private Integer hourlyWage;

    @ApiModelProperty(value = "人均工资")
    @TableField("per_money")
    private BigDecimal perMoney;

    @ApiModelProperty(value = "总计工资")
    @TableField("total_money")
    private BigDecimal totalMoney;

    @ApiModelProperty(value = "计薪方式 1按人 2按总价 3按时薪")
    @TableField("money_mode")
    private Integer moneyMode;

    @ApiModelProperty(value = "用工职位")
    @TableField("position")
    private String position;

    @ApiModelProperty(value = "工作内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "保证金金额")
    @TableField("bond_money")
    private BigDecimal bondMoney;

    @ApiModelProperty(value = "订单状态 0未支付 10已支付 11排队中 12已上麦 20已发布 30等待中(选人中) 35派单结束 40等待开工 45干活中 50已完成 60已结束 70订单取消")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "雇主确认状态 0未确认 1已确定")
    @TableField("confirm_status")
    private Integer confirmStatus;

    @ApiModelProperty(value = "失败类型 0未失败 1无人接单  2人足超时未选 3人不足超时未选 4支付超时 5停止派单 6管理端结束")
    @TableField("error_status")
    private Integer errorStatus;

    @ApiModelProperty(value = "评价状态 0未评价 1已评价")
    @TableField("evaluate_status")
    private Integer evaluateStatus;

    @ApiModelProperty(value = "畅聊状态 0，未开通 1，已开通 第一个雇工开通畅聊问话后，修改此状态")
    @TableField("chat_status")
    private Integer chatStatus;

    @ApiModelProperty(value = "补救标志 1非补救订单 2补救订单")
    @TableField("repair_mark")
    private Integer repairMark;

    @ApiModelProperty(value = "编辑重发标志 1非编辑重发 2编辑重发")
    @TableField("edit_mark")
    private Integer editMark;

    @ApiModelProperty(value = "标准订单标志 1标准订单 2简易订单")
    @TableField("standard_mark")
    private Integer standardMark;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "派单结束时间")
    @TableField("dispatch_end_time")
    private LocalDateTime dispatchEndTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "是否管理端结束（0-否，1-是）")
    @TableField("is_admin_end")
    private Boolean adminEnd;

    @ApiModelProperty(value = "工作地点区域编号")
    @TableField("work_division_code")
    private String workDivisionCode;

    @ApiModelProperty(value = "工作地点")
    @TableField("work_area")
    private String workArea;

    @ApiModelProperty(value = "工作地点纬度")
    @TableField("work_lat")
    private BigDecimal workLat;

    @ApiModelProperty(value = "工作地点经度")
    @TableField("work_lng")
    private BigDecimal workLng;

    @ApiModelProperty(value = "发布地点区域编号")
    @TableField("release_division_code")
    private String releaseDivisionCode;

    @ApiModelProperty(value = "发布地点")
    @TableField("release_area")
    private String releaseArea;

    @ApiModelProperty(value = "发布地点纬度")
    @TableField("release_lat")
    private BigDecimal releaseLat;

    @ApiModelProperty(value = "发布地点经度")
    @TableField("release_lng")
    private BigDecimal releaseLng;
    
    @ApiModelProperty(value = "接送地点区域编号")
    @TableField("pickup_division_code")
    private String pickupDivisionCode;

    @ApiModelProperty(value = "接送地点")
    @TableField("pickup_area")
    private String pickupArea;

    @ApiModelProperty(value = "接送地点纬度")
    @TableField("pickup_lat")
    private BigDecimal pickupLat;

    @ApiModelProperty(value = "接送地点经度")
    @TableField("pickup_lng")
    private BigDecimal pickupLng;
    
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
}
