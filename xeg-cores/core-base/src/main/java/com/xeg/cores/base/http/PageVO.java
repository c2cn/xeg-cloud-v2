package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
@Data
@ApiModel(value = "分页返回对象", description = "分页返回对象")
public class PageVO<T> implements Serializable {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Long current;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Long pages;
    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小")
    private Long size;
    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    private Long total;
    /**
     * 当前页记录
     */
    @ApiModelProperty(value = "当前页记录")
    private List<T> list;
}
