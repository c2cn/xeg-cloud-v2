package com.xeg.cores.mongo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/5/29 10:41
 */
@Data
public class MongoUserLocationDTO implements Serializable {

    private static final long serialVersionUID = 503198595640021726L;

    private Long userId;

    private String areaCode;

    private Double lng;

    private Double lat;

    private Integer age;

    private Integer sex;

    private Double range;
}
