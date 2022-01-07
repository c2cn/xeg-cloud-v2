package com.xeg.servers.order.domain.entity;

import java.io.Serializable;
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
	* @date   2021年11月4日 下午5:36:28
	* @version v1.0.0
	* @Description	短工大厅雇主下单时技能要求
	* NoticeOrderProblem.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:36:28       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_notice_order_problem")
@ApiModel(value="BusNoticeOrderProblem对象", description="短工大厅雇主下单时技能要求")
public class NoticeOrderProblem implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号(仅限短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "问题内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "答案 0否 1是")
    @TableField("answer")
    private String answer;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
