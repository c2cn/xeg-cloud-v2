package com.xeg.servers.user.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 雇主登录展示对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "雇主登录展示对象", description = "雇主登录展示对象")
public class EmployerLoginVO implements Serializable {

    private static final long serialVersionUID = -5553209215668746390L;

    @ApiModelProperty(value = "在线工人数量")
    private Integer workerNum;

    @ApiModelProperty(value = "信用分")
    private Integer creditScore;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String headImg;

}
