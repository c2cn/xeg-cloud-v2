package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "批量查询用户在群组中的身份查询返回对象", description = "批量查询用户在群组中的身份查询返回对象")
public class ImOnlineMemberNumReturn extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("OnlineMemberNum")
    private Long onlineMemberNum;

}
