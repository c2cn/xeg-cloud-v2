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
 * 用户身份关联表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_agent_identity")
@ApiModel(value="AgentIdentity对象", description="用户身份关联表")
public class AgentIdentity implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代理编号")
    @TableField("agent_id")
    private Long agentId;

    @ApiModelProperty(value = "身份编号")
    @TableField("identity_id")
    private Long identityId;

    @ApiModelProperty(value = "地区码")
    @TableField("area_code")
    private String areaCode;

    @ApiModelProperty(value = "6位邀请码")
    @TableField("invite_code")
    private String inviteCode;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "是否删除 0 未删除  1已删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "角色编号")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty(value = "服务费0-99/100")
    @TableField("charge")
    private Integer charge;


}
