package com.xeg.servers.agent.domain.entity;

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
 * 代理商信息表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_agent")
@ApiModel(value="AgentInfo对象", description="代理商信息表")
public class AgentInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "账号编号")
    @TableField("admin_id")
    private Long adminId;

    @ApiModelProperty(value = "代理名称")
    @TableField("agent_name")
    private String agentName;

    @ApiModelProperty(value = "上级代理编号")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "代理类型  1 一级代理 2 二级代理")
    @TableField("agent_type")
    private Integer agentType;

    @ApiModelProperty(value = "0正常，1预禁用，2禁用")
    @TableField("disable_status")
    private Boolean disableStatus;

    @ApiModelProperty(value = "0正常，1为预冻结，2冻结")
    @TableField("frozen_status")
    private Boolean frozenStatus;

    @ApiModelProperty(value = "缴费状态 0未缴费 1已缴费")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "是否为平台代理0否，1是")
    @TableField("is_special")
    private Integer isSpecial;

    @ApiModelProperty(value = "是否允许跨区域0否，1是")
    @TableField("is_cross_region")
    private Integer isCrossRegion;

    @ApiModelProperty(value = "代理过期时间")
    @TableField("fire_time")
    private LocalDateTime fireTime;

    @ApiModelProperty(value = "是否删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private String createUser;


}
