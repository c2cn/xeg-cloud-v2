package com.xeg.servers.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 用户业务非法花名册表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bus_user_illegal_roster")
@ApiModel(value="BusUserIllegalRoster对象", description="用户业务非法花名册表")
public class BusUserIllegalRoster implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "用户类型 1工人 2雇主")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value = "类型 1->冻结 2->禁用")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "解除类型 1->解除冻结 2->解除禁用")
    @TableField("relieve_type")
    private Integer relieveType;

    @ApiModelProperty(value = "是否正式状态 0->否 1->是")
    @TableField("formal_status")
    private Integer formalStatus;

    @ApiModelProperty(value = "禁用业务url_code")
    @TableField("disable_url_code")
    private String disableUrlCode;

    @ApiModelProperty(value = "拉黑开始时间")
    @TableField("start_time")
    private Long startTime;

    @ApiModelProperty(value = "拉黑结束时间")
    @TableField("end_time")
    private Long endTime;

    @ApiModelProperty(value = "审核状态 0->无 1->审核中 2->通过 3->未通过")
    @TableField("audit_status")
    private Integer auditStatus;

    @ApiModelProperty(value = "审核人ID")
    @TableField("auditor")
    private Long auditor;

    @ApiModelProperty(value = "审核说明")
    @TableField("audit_content")
    private String auditContent;

    @ApiModelProperty(value = "审核时间")
    @TableField("audit_time")
    private Long auditTime;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @ApiModelProperty(value = "预删除(管理端准备删除冻结的数据使用) 0正常 1预删除")
    @TableField("pre_del")
    private Integer preDel;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;


}
