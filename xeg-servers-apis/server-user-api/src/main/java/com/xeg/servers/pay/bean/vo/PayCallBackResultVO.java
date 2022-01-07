package com.xeg.servers.pay.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
	* @author xian
	* @date   2021年11月4日 下午1:36:43
	* @version v1.0.0
	* @Description	回调结果展示对象VO
	* PayCallBackResultVO.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午1:36:43       xian            v1.0.0           Created
 */
@Getter
@Setter
@ApiModel(value = "回调结果展示对象", description = "回调结果展示对象")
public class PayCallBackResultVO implements Serializable {
    private static final long serialVersionUID = 1;
	
    @ApiModelProperty(value = "失败状态 0成功 1失败")
    private int failStatus;
    
    @ApiModelProperty(value = "失败编号")
    private String failCode;
    
    @ApiModelProperty(value = "失败描述")
    private String failDesc;
    
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    
    @ApiModelProperty(value = "订单批次")
    private String orderBatch;
    
    @ApiModelProperty(value = "聊天室ID 成功才返回")
    private String chatImid;

    @ApiModelProperty(value = "是否派单结束 0派单结束 1派单中")
    private Integer isDispatch;

    @ApiModelProperty(value = "议价表bid 短工特有")
    private Long bid;
    
    @ApiModelProperty(value = "招工倒计时 短工特有")
    private BigDecimal noticeDuration;
    
    @ApiModelProperty(value = "直播间订单排队位置")
    private Integer orderPosition;
}
