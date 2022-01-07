package com.xeg.servers.user.domain.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表(雇主)
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_employer")
@ApiModel(value="EmployerInfo对象", description="用户表(雇主)")
public class EmployerInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "雇主表id")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户信息表id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "信用分")
    @TableField("credit_score")
    private Integer creditScore;

    @ApiModelProperty(value = "纬度")
    @TableField("lat")
    private BigDecimal lat;

    @ApiModelProperty(value = "经度")
    @TableField("lng")
    private BigDecimal lng;

    @ApiModelProperty(value = "城市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "头像")
    @TableField("head_img")
    private String headImg;

    @ApiModelProperty(value = "成单次数")
    @TableField("finish_number")
    private Integer finishNumber;

    @ApiModelProperty(value = "0正常1待观察用户")
    @TableField("observed_flg")
    private Integer observedFlg;

    @ApiModelProperty(value = "状态0->正常 1->预冻结 2->冻结")
    @TableField("frozen_status")
    private Integer frozenStatus;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;


}
