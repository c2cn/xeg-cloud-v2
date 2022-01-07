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
 * 用户上级代理关联表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_user_agent")
@ApiModel(value="UserAgent对象", description="用户上级代理关联表")
public class UserAgent implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户Id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "代理身份关联表Id")
    @TableField("agent_identity_id")
    private Long agentIdentityId;

    @ApiModelProperty(value = "1劳务市场")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "0未删除 1已删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;


}
