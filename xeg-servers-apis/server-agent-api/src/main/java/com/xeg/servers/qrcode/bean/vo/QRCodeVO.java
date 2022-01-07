package com.xeg.servers.qrcode.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:58
 * @Description 二维码展示对象
 * QRCodeVO
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:58 xulp v1.0.0 Created
 */
@Data
@ApiModel(value = "二维码展示对象", description = "二维码展示对象")
public class QRCodeVO implements Serializable {

    private static final long serialVersionUID = 7743142065705470468L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "最大邀请数")
    private Integer maxNumber;

    @ApiModelProperty(value = "最小邀请数")
    private Integer minNumber;

    @ApiModelProperty(value = "雇工是雇主的N倍")
    private Integer proportion;
}
