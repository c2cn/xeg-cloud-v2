package com.xeg.cores.mongo.bean;

import com.xeg.cores.mongo.annotation.QueryField;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author ningpeng
 * @description: 用户定位 mongo对象
 * @date 2021/5/10 13:51
 */
@Document("userLocation")
@Data
public class MongoUserLocation implements Serializable {
    private static final long serialVersionUID = -8517478108772454830L;
    /**
     * 用户编号
     */
    @QueryField
    private Long userId;

    /**
     * 雇工经纬度
     */
    private HashMap<String, Object> loc;

    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 当前地区编码
     */
    private String areaCode;

}
