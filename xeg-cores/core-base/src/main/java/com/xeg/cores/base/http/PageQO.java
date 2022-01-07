package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description //TODO
 * @Author Qi Ding
 * @Date 2020/11/6 2:04 下午
 * @Version 1.0
 */
@Data
@ApiModel(value = "分页查询对象", description = "分页查询对象")
public class PageQO implements Serializable {


    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", required = true, dataType = "Integer", example = "1")
    private Integer pageNum = 1;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量", required = true, dataType = "Integer", example = "10")
    private Integer pageSize = 10;

    /**
     * 是否分页 0不分页 1分页
     */
    @ApiModelProperty(value = "是否分页 0不分页 1分页", dataType = "Integer", example = "1")
    private Integer isPaged = 1;

    /**
     * 数据所在位置
     */
    @ApiModelProperty(value = "数据所在位置")
    private Long dataLocation;
}
