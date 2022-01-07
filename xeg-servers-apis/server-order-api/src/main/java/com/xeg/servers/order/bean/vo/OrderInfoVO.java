package com.xeg.servers.order.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
	* @author xian
	* @date   2021年11月4日 下午5:38:02
	* @version v1.0.0
	* @Description	订单基本信息表VO
	* Order.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:38:02       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Order对象", description="订单基本信息表")
public class OrderInfoVO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private Integer bid;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "雇主id")
    private Integer employerId;

    @ApiModelProperty(value = "直播间id")
    private Integer liveId;

    @ApiModelProperty(value = "订单来源 1劳务单 2召集单 3常用单 4短工大厅 5直播间 6技工单")
    private Integer orderSource;

    @ApiModelProperty(value = "订单类型 1定价单 2竞价单")
    private Integer orderType;

    @ApiModelProperty(value = "订单批次")
    private String orderBatch;

    @ApiModelProperty(value = "人数")
    private Integer number;

    @ApiModelProperty(value = "时薪")
    private Integer hourlyWage;

    @ApiModelProperty(value = "人均工资")
    private BigDecimal perMoney;

    @ApiModelProperty(value = "总计工资")
    private BigDecimal totalMoney;

    @ApiModelProperty(value = "计薪方式 1按人 2按总价 3按时薪")
    private Integer moneyMode;

    @ApiModelProperty(value = "用工职位")
    private String position;

    @ApiModelProperty(value = "工作内容")
    private String content;

    @ApiModelProperty(value = "保证金金额")
    private BigDecimal bondMoney;

    @ApiModelProperty(value = "订单成单类型：1-人工 2-自动")
    private Boolean orderFormType;

    @ApiModelProperty(value = "订单最终成单类型：1-人工 2-自动")
    private Boolean orderFormTypeComplete;

    @ApiModelProperty(value = "订单状态 0未支付 10已支付 11排队中 12已上麦 20已发布 30等待中(选人中) 35派单结束 40等待开工 45干活中 50已完成 60已结束 70订单取消")
    private Integer status;

    @ApiModelProperty(value = "雇主确认状态 0未确认 1已确定")
    private Integer confirmStatus;

    @ApiModelProperty(value = "失败类型 0未失败 1无人接单  2人足超时未选 3人不足超时未选 4支付超时 5停止派单 6管理端结束")
    private Integer errorStatus;

    @ApiModelProperty(value = "评价状态 0未评价 1已评价")
    private Integer evaluateStatus;

    @ApiModelProperty(value = "畅聊状态 0，未开通 1，已开通 第一个雇工开通畅聊问话后，修改此状态")
    private Integer chatStatus;

    @ApiModelProperty(value = "补救标志 1非补救订单 2补救订单")
    private Integer repairMark;

    @ApiModelProperty(value = "编辑重发标志 1非编辑重发 2编辑重发")
    private Integer editMark;

    @ApiModelProperty(value = "标准订单标志 1标准订单 2简易订单")
    private Integer standardMark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "派单结束时间")
    private LocalDateTime dispatchEndTime;

    @ApiModelProperty(value = "上麦时间")
    private LocalDateTime servingWheatTime;

    @ApiModelProperty(value = "下麦时间")
    private LocalDateTime downWheatTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "上架状态（0：未上架，1：上架）")
    private Integer isShow;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "修改人")
    private Integer updateBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
    private Integer isDel;

    @ApiModelProperty(value = "是否管理端结束（0-否，1-是）")
    private Boolean adminEnd;
    
    
}
