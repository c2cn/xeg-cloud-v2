package com.xeg.cores.mongo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhang Zhongkun
 * @description: 定位
 * @date 2021/5/10 13:51
 */
@Data
public class MongoLocationVO implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lng;
}
