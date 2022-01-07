package com.xeg.cores.base.im.message;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@Data
public class ImSystemUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "发送方ImId")
    private String id;

    @ApiModelProperty(value = "发送方名字")
    private String name;

    @ApiModelProperty(value = "发送方头像")
    private String avatar;

    @ApiModelProperty(value = "发送方角色 worker/employer/admin/customer_service/presenter")
    private String role;

    public ImSystemUserDTO(String id, String name, String avatar){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.role = "admin";
    }
}
