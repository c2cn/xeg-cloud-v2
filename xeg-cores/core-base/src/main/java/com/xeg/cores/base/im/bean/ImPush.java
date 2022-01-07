package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@Data
@ApiModel(value = "全员推送对象", description = "全员推送对象")
public class ImPush implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要设置该 UserID 的资料", required = true, example = "maxiaoya")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty(value = "消息随机数，由随机函数产生。用于推送任务去重", hidden = true)
    @JsonProperty("MsgRandom")
    private Integer msgRandom;

    @ApiModelProperty(value = "消息离线存储时间，单位秒，最多保存7天（604800秒）。默认为0，表示不离线存储")
    @JsonProperty("MsgLifeTime")
    private Integer msgLifeTime;

    @ApiModelProperty(value = "消息内容", required = true)
    @JsonProperty("MsgBody")
    private List<ImMsgBody> msgBody;

    @ApiModelProperty(value = "离线推送信息配置")
    @JsonProperty("OfflinePushInfo")
    private ImOfflinePushInfo offlinePushInfo;

    /**
     * Condition 共有4种条件类型，分别是：
     * 属性的或条件 AttrsOr
     * 属性的与条件 AttrsAnd
     * 标签的或条件 TagsOr
     * 标签的与条件 TagsAnd
     * AttrsOr 和 AttrsAnd 可以并存，TagsOr 和 TagsAnd 也可以并存。但是标签和属性条件不能并存。如果没有 Condition，则推送给全部用户
     */
    @ApiModelProperty(value = "推送条件")
    @JsonProperty("Condition")
    private ImCondition condition;

}
