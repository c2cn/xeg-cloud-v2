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
	* @date   2021年11月4日 下午5:33:50
	* @version v1.0.0
	* @Description	聊天室
	* ChatRoom.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:33:50       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_chat_room")
@ApiModel(value="ChatRoom对象", description="聊天室")
public class ChatRoom implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "IM聊天室编号")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "0未删除  1 已删除 2 待激活")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "1 劳务市场普通聊天群 20短工大厅成单聊天室  30短工大厅抢单临时聊天室")
    @TableField("type")
    private Integer type;


}
