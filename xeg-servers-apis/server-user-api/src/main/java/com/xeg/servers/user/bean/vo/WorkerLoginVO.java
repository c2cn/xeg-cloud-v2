package com.xeg.servers.user.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户登录传输对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "工人登录展示对象", description = "工人登录展示对象")
public class WorkerLoginVO implements Serializable {

    private static final long serialVersionUID = 6326105456633991965L;

    @ApiModelProperty(value = "信用驾照分")
    private Integer creditScore;

    @ApiModelProperty(value = "保证金状态 1 已缴纳 2 未缴纳")
    private int deposit;

    @ApiModelProperty(value = "完成订单总数")
    private Integer orderNum;

    @ApiModelProperty(value = "订单总金额")
    private BigDecimal orderTotal;

    @ApiModelProperty(value = "收到的派单总次数")
    private Integer dispatchNum;

    @ApiModelProperty(value = "接单状态 0停止接单 1进入接单")
    private Integer receiptState;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String headImg;
}
