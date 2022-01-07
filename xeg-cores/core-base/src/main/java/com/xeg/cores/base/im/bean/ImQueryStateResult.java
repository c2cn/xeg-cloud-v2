package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "批量查询在线状态返回对象", description = "批量查询在线状态返回对象")
public class ImQueryStateResult extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "返回的用户在线状态结构化信息")
    @JsonProperty("QueryResult")
    private List<QueryResult> queryResult;

    @ApiModelProperty(value = "状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空")
    @JsonProperty("ErrorList")
    private List<ErrorList> errorList;

    @Data
    @ApiModel(value = "返回的用户在线状态结构化信息", description = "返回的用户在线状态结构化信息")
    public static class QueryResult implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "返回的用户的 UserID", required = true)
        @JsonProperty("To_Account")
        private String toAccount;

        /**
         * 返回的用户状态，目前支持的状态有：
         * 前台运行状态（Online）：客户端登录后和即时通信 IM 后台有长连接
         * 后台运行状态（PushOnline）：iOS 和 Android 进程被 kill 或因网络问题掉线，进入 PushOnline 状态，此时仍然可以接收消息的离线推送。客户端切到后台，但是进程未被手机操作系统 kill 掉时，此时状态仍是 Online
         * 未登录状态（Offline）：客户端主动退出登录或者客户端自上一次登录起7天之内未登录过
         * 如果用户是多终端登录，则只要有一个终端的状态是 Online ，该字段值就是 Online
         */
        @ApiModelProperty(value = "返回的用户状态", required = true)
        @JsonProperty("Status")
        private String status;

        @ApiModelProperty(value = "详细的登录平台信息", required = true)
        @JsonProperty("Detail")
        private List<Detail> detail;

        @Data
        @ApiModel(value = "详细的登录平台信息", description = "详细的登录平台信息")
        public static class Detail implements Serializable {
            private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "登录的平台类型。可能的返回值有：\"iPhone\", \"Android\", \"Web\", \"PC\", \"iPad\", \"Mac\"")
            @JsonProperty("Platform")
            private String platform;

            @ApiModelProperty(value = "该登录平台的状态")
            @JsonProperty("Status")
            private String status;
        }
    }

    @Data
    @ApiModel(value = "状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空", description = "状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空")
    public static class ErrorList implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "状态查询失败的目标帐号")
        @JsonProperty("To_Account")
        private String toAccount;

        @ApiModelProperty(value = "状态查询失败的错误码，若目标帐号的错误码为70107，表示该帐号不存在")
        @JsonProperty("ErrorCode")
        private Integer errorCode;
    }
}
