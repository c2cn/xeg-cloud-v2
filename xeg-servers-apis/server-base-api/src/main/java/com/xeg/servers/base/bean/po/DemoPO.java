package com.xeg.servers.base.bean.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackageName：com.xiaoergekeji.server.agent.bean.po
 * @ClassName：DemoPO
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:25
 */
@Data
public class DemoPO {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

}
