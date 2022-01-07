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
 * 恶意订单表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_order_malicious")
@ApiModel(value="BusOrderMalicious对象", description="恶意订单表")
public class BusOrderMalicious implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "举报编号")
    @TableField("sequence_no")
    private String sequenceNo;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "处理结果,1有效举报,2无效举报,3恶意举报")
    @TableField("process_result")
    private Integer processResult;

    @ApiModelProperty(value = "判定来源 1平台 2工人 3雇主")
    @TableField("source")
    private Integer source;

    @ApiModelProperty(value = "工人/雇主id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "判定内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "图片")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "审核人id")
    @TableField("audit_id")
    private Integer auditId;

    @ApiModelProperty(value = "审核状态 1待处理,2已处理")
    @TableField("audit_status")
    private Integer auditStatus;

    @ApiModelProperty(value = "审核原因")
    @TableField("audit_desc")
    private String auditDesc;

    @ApiModelProperty(value = "审核时间")
    @TableField("audit_time")
    private LocalDateTime auditTime;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "举报类型")
    @TableField("report_type")
    private String reportType;

    @ApiModelProperty(value = "联系方式")
    @TableField("contact")
    private String contact;


}
