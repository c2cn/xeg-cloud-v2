package com.xeg.servers.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付回调失败记录表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_paycallback_fail_record")
@ApiModel(value="PaycallbackFailRecord对象", description="支付回调失败记录表")
public class PaycallbackFailRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "场景类型 10抢单 11议价 12直播间排队 13直播间报价自荐 20发布订单")
    @TableField("scene_type")
    private Integer sceneType;

    @ApiModelProperty(value = "用户类型 1工人 2雇主")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value = "工人/雇主id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty(value = "订单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "失败编号")
    @TableField("fail_code")
    private String failCode;

    @ApiModelProperty(value = "失败描述")
    @TableField("fail_desc")
    private String failDesc;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
    @TableField("is_del")
    private Integer isDel;


}
