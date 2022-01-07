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
	* @date   2021年11月4日 下午5:39:37
	* @version v1.0.0
	* @Description	举报类型表
	* OrderMaliciousType.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:39:37       xian            v1.0.0           Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_order_malicious_type")
@ApiModel(value="BusOrderMaliciousType对象", description="举报类型表")
public class OrderMaliciousType implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "举报类型名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "是否显示,0显示,1隐藏")
    @TableField("is_show")
    private Integer isShow;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "修改 时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除,0未删除,1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "排序")
    @TableField("role_sort")
    private Integer roleSort;


}
