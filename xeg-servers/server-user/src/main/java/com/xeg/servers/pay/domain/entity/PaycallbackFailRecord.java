package com.xeg.servers.pay.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
	* @author xian
	* @date   2021年11月4日 下午2:00:48
	* @version v1.0.0
	* @Description	支付回调失败记录表
	* PaycallbackFailRecord.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午2:00:48       xian            v1.0.0           Created
 */
@Getter
@Setter
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
    @TableField(value = "is_del", fill = FieldFill.INSERT)
    private Integer isDel;


}
