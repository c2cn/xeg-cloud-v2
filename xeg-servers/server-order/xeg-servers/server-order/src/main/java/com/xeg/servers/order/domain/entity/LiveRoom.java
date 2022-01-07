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
 * 直播间
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_live_room")
@ApiModel(value="LiveRoom对象", description="直播间")
public class LiveRoom implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "直播间名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "直播间编号 英文+数字")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "直播间所在地行政编码")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "直播间所在街道名称")
    @TableField("street_name")
    private String streetName;

    @ApiModelProperty(value = "直播间所在地")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "纬度")
    @TableField("lat")
    private BigDecimal lat;

    @ApiModelProperty(value = "经度")
    @TableField("lng")
    private BigDecimal lng;

    @ApiModelProperty(value = "工作性质  (小时工/日工/多日短工/长期工)")
    @TableField("work_property")
    private String workProperty;

    @ApiModelProperty(value = "顺序发言延时时长 单位:秒")
    @TableField("sequence_extend_duration")
    private Integer sequenceExtendDuration;

    @ApiModelProperty(value = "统一报价延时时长 单位:秒")
    @TableField("offer_extend_duration")
    private Integer offerExtendDuration;

    @ApiModelProperty(value = "报价自荐金额")
    @TableField("oneself_offer_money")
    private BigDecimal oneselfOfferMoney;

    @ApiModelProperty(value = "进行中订单数量")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "完成订单数量")
    @TableField("finish_num")
    private Integer finishNum;

    @ApiModelProperty(value = "直播间状态 0休息中 1直播中 ")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "代理id")
    @TableField("agent_id")
    private Integer agentId;

    @ApiModelProperty(value = "该房间是否为主持人房间  0，是 1，不是")
    @TableField("is_host")
    private Integer isHost;

    @ApiModelProperty(value = "0未禁用 1已禁用")
    @TableField("is_disable")
    private Integer isDisable;

    @ApiModelProperty(value = "0未删除 1已删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "直播间创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
