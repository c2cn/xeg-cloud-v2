package com.xeg.cores.redis.init.builders;


import com.xeg.cores.base.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengyuanming
 * @version 2.0
 * @since 7.0
 * 2019/4/17 0017 16:30
 */
public class RedisNodeBuilder {

    public static List<String> build(String nodes) {
        if (StringUtil.isEmpty(nodes)) {
            throw new RuntimeException("redis 配置错误：集群节点为空");
        }

        List<String> nodeList = new ArrayList<>();

        String[] nodeAr = nodes.split(",");
        for (String node : nodeAr) {
            String[] ipAndPort = node.split(":");
            if (ipAndPort.length < 2) {
                continue;
            }
            nodeList.add(node);
        }

        return nodeList;
    }
}
