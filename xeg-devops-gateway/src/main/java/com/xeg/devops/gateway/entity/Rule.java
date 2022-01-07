package com.xeg.devops.gateway.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/4/25 22:22
 */
@Data
public class Rule {
    /**
     * IP白名单，List列表形式
     */
    private List<String> initWhiteIpList = new ArrayList<>();
    /**
     * IP黑名单，List列表形式
     */
    private List<String> initBlackIpList = new ArrayList<>();
    /**
     * 忽略URL，List列表形式
     * 黑名单
     */
    private List<String> initBlacklist = new ArrayList<>();
    /**
     * 忽略URL，List列表形式
     * 白名单
     */
    private List<String> initWhitelist = new ArrayList<>();
    /**
     * 是否启用网关鉴权模式
     */
    private boolean initEnable = true;

}
