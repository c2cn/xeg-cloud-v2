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
	* @date   2021年11月4日 下午5:38:13
	* @version v1.0.0
	* @Description	订单地点信息表
	* OrderAddress.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:38:13       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_address")
@ApiModel(value="OrderAddress对象", description="订单地点信息表")
public class OrderAddress implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "订单编号(仅短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    private Integer orderId;

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

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
