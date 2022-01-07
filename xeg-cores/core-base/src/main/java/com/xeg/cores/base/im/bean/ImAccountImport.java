package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 14:16
 **/
@Data
@ApiModel(value = "创建用户IM对象", description = "创建用户IM对象")
public class ImAccountImport implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名，长度不超过32字节(必填)
     */
    @JsonProperty("Identifier")
    private String identifier;

    /**
     * 用户昵称(选填)
     */
    @JsonProperty("Nick")
    private String nick;

    /**
     * 用户头像 URL(选填)
     */
    @JsonProperty("FaceUrl")
    private String faceUrl;

    @ApiModelProperty(value = "userType 1雇工，2雇主，3主持人，4管理员", required = true, example = "1")
    @NotNull(message = "userType 不能为空")
    private Integer userType;
}
