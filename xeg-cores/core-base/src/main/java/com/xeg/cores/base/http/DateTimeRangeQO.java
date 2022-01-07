package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description 查询条件含有时间范围
 * @Author Zhongkun Zhang
 * @Date 2021/5/10 8:51
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DateTimeRangeQO extends PageQO implements Serializable {

    @ApiModelProperty(value = "开始时间", dataType = "Long", example = "1621008000000")
    private Long startTime;

    @ApiModelProperty(value = "结束时间", dataType = "Long", example = "1621094399000")
    private Long endTime;
}
