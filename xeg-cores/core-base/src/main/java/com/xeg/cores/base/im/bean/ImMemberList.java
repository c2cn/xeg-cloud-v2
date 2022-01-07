package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description: 群组内成员详细信息
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ImMemberList extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "成员账号")
    @JsonProperty("Member_Account")
    private String memberAccount;

    @ApiModelProperty(value = "加人结果：0 为失败；1 为成功；2 为已经是群成员")
    @JsonProperty("Result")
    private String result;
}
