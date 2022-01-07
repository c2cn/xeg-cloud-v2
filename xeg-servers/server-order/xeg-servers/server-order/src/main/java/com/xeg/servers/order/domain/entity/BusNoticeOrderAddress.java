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
 * 短工大厅工作地点和接送地点
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order_address")
@ApiModel(value="BusNoticeOrderAddress对象", description="短工大厅工作地点和接送地点")
public class BusNoticeOrderAddress implements Serializable {

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

    @ApiModelProperty(value = "发布地点省份编号")
    @TableField("release_province_code")
    private String releaseProvinceCode;

    @ApiModelProperty(value = "发布地点城市编号")
    @TableField("release_city_code")
    private String releaseCityCode;

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
