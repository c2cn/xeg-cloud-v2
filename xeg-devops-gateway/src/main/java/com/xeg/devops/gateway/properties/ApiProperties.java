package com.xeg.devops.gateway.properties;

import com.xeg.devops.gateway.entity.Rule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 验证权限配置
 *
 * @author pangu
 * @date 2020-10-28
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "rule")
public class ApiProperties {

    /**
     * 忽略URL，List列表形式
     * 黑名单
     */
    private static List<String> blacklist = new ArrayList<>();
    /**
     * 忽略URL，List列表形式
     * 白名单
     */
    private static List<String> whitelist = new ArrayList<>();
    /**
     * IP白名单，List列表形式
     */
    private static List<String> whiteIpList = new ArrayList<>();
    /**
     * IP黑名单，List列表形式
     */
    private static List<String> blackIpList = new ArrayList<>();
    /**
     * 是否启用网关鉴权模式
     */
    private static boolean enable = true;
    private List<String> initBlacklist = new ArrayList<>();
    private List<String> initWhitelist = new ArrayList<>();
    private List<String> initWhiteIpList = new ArrayList<>();
    private List<String> initBlackIpList = new ArrayList<>();
    private boolean initEnable = true;

    public static void updateUrlRule(Rule rule) {
        whitelist = rule.getInitWhitelist();
        blacklist = rule.getInitBlacklist();
        whiteIpList = rule.getInitWhiteIpList();
        blackIpList = rule.getInitBlackIpList();
        enable = rule.isInitEnable();
    }

    public static List<String> getBlacklist() {
        return blacklist;
    }

    public static void setBlacklist(List<String> blacklist) {
        ApiProperties.blacklist = blacklist;
    }

    public static List<String> getWhitelist() {
        return whitelist;
    }

    public static void setWhitelist(List<String> whitelist) {
        ApiProperties.whitelist = whitelist;
    }

    public static List<String> getWhiteIpList() {
        return whiteIpList;
    }

    public static void setWhiteIpList(List<String> whiteIpList) {
        ApiProperties.whiteIpList = whiteIpList;
    }

    public static List<String> getBlackIpList() {
        return blackIpList;
    }

    public static void setBlackIpList(List<String> blackIpList) {
        ApiProperties.blackIpList = blackIpList;
    }

    public static boolean getEnable() {
        return enable;
    }

    public static void setEnable(boolean enable) {
        ApiProperties.enable = enable;
    }

    @PostConstruct
    public void initIgnoreUrl() {
        enable = initEnable;
        blacklist = initBlacklist;
        whitelist = initWhitelist;
        whiteIpList = initWhiteIpList;
        blackIpList = initBlackIpList;
    }
}