package com.xeg.servers.order.domain.entity;

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
 * 订单评价表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_evaluate")
@ApiModel(value="OrderEvaluate对象", description="订单评价表")
public class OrderEvaluate implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号(仅短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "订单批次")
    @TableField("order_batch")
    private String orderBatch;

    @ApiModelProperty(value = "评价的对应订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "评价类型 1工人评价雇主 2雇主评价工人 3系统自动评价")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty(value = "被评价用户id")
    @TableField("to_uid")
    private Integer toUid;

    @ApiModelProperty(value = "评价内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "星星数量 (1-2星差评，3-4星中评，5星好评)")
    @TableField("stars_number")
    private Integer starsNumber;

    @ApiModelProperty(value = "图片/视频，逗号隔开")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "是否已读 0未读 1已读")
    @TableField("is_read")
    private Boolean read;

    @ApiModelProperty(value = "评论是否显示，0显示，1隐藏")
    @TableField("show_status")
    private Integer showStatus;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "评价时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "0未删除。1已删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;


}
