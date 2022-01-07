package com.xeg.servers.qrcode.domain.entity;

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
 * 二维码
 * </p>
 *
 * @author xxx
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_qr_code")
@ApiModel(value="QrCode对象", description="二维码")
public class QrCode implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代理身份ID")
    @TableField("agent_identity_id")
    private Long agentIdentityId;

    @ApiModelProperty(value = "最大邀请数")
    @TableField("max_number")
    private Integer maxNumber;

    @ApiModelProperty(value = "最小邀请数")
    @TableField("min_number")
    private Integer minNumber;

    @ApiModelProperty(value = "雇工是雇主的N倍")
    @TableField("proportion")
    private Integer proportion;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @ApiModelProperty(value = "代理类型 1 劳务市场 2 劳务派遣企业 3 劳务派遣 工人")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "邀请码")
    @TableField("invite_code")
    private String inviteCode;

    @ApiModelProperty(value = "二维码url(oss)")
    @TableField("qr_code_url")
    private String qrCodeUrl;

    @ApiModelProperty(value = "生成二维码的值")
    @TableField("qr_code_value")
    private String qrCodeValue;

    @ApiModelProperty(value = "是否删除 0未删 1删")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Boolean del;


}
