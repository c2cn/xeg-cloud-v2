package com.xeg.cores.mongo.qo;

import com.xeg.cores.mongo.annotation.QueryField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/5/29 11:31
 */

@Data
public class QueryQO implements Serializable {
    @QueryField
    private Long userId;
}
