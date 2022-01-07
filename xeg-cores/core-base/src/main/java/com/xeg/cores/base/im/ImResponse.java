package com.xeg.cores.base.im;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/****
 * @Description
 * @Author Zhongkun Zhang
 * @Data create in 2021/5/31 11:13
 * @Version 1.0
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "IM消息响应体", description = "IM消息响应体")
public class ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    /***
     * ActionStatus	String	请求处理的结果，OK 表示处理成功，FAIL 表示失败
     * ErrorCode	Integer	错误码，0表示成功，非0表示失败
     * ErrorInfo	String	错误信息
     * MsgTime	Integer	消息发送的时间戳，对应后台 server 时间
     * MsgSeq	Integer	消息序列号，唯一标示一条消息
     */
    @ApiModelProperty(value = "OK 表示处理成功，FAIL 表示失败")
    @JsonProperty("ActionStatus")
    private String actionStatus;

    @ApiModelProperty(value = "表示成功，非0表示失败")
    @JsonProperty("ErrorCode")
    private Integer errorCode;

    @ApiModelProperty(value = "错误信息")
    @JsonProperty("ErrorInfo")
    private String errorInfo;
}
