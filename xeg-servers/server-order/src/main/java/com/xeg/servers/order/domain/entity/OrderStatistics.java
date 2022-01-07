package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
	* @author xian
	* @date   2021年11月4日 下午5:40:56
	* @version v1.0.0
	* @Description	订单信息统计
	* OrderStatistics.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:40:56       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_statistics")
@ApiModel(value="OrderStatistics对象", description="订单信息统计")
public class OrderStatistics implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "工人/雇主编号")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty(value = "用户类型 1工人 2雇主")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value = "订单类型 1劳务单 2短工大厅 3直播大厅")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty(value = "订单数量")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
