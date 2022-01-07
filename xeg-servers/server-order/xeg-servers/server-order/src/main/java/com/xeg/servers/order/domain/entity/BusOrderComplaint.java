package com.xeg.servers.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单举报表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_order_complaint")
@ApiModel(value="BusOrderComplaint对象", description="订单举报表")
public class BusOrderComplaint implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "举报内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "举报用户Id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "举报时间")
    @TableField("report_time")
    private LocalDateTime reportTime;

    @ApiModelProperty(value = "图片|视频链接")
    @TableField("url")
    private String url;


}
