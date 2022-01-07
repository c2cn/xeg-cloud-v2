package com.xeg.devops.gateway.init;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.xeg.devops.gateway.entity.GatewayRoute;
import com.xeg.devops.gateway.entity.UrlRule;
import com.xeg.devops.gateway.properties.ApiProperties;
import com.xeg.cores.base.constant.XegConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 动态路由初始化类
 *
 * @author ningpeng
 * @since 2.3.8
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DynamicRouteInit {

    private final RouteDefinitionWriter routeDefinitionWriter;
    private final NacosConfigProperties nacosProperties;

    @PostConstruct
    public void initRoute() {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, nacosProperties.getServerAddr());
            properties.put(PropertyKeyConst.USERNAME, nacosProperties.getUsername());
            properties.put(PropertyKeyConst.PASSWORD, nacosProperties.getPassword());
            properties.put(PropertyKeyConst.NAMESPACE, nacosProperties.getNamespace());
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = "";
            try {
                content = configService.getConfig(XegConstant.CONFIG_DATA_ID_DYNAMIC_ROUTES, nacosProperties.getGroup(), XegConstant.CONFIG_TIMEOUT_MS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("初始化网关路由开始");
            updateRoute(content);
            log.info("初始化网关路由完成");
            // 开起监听，实现动态
            // 更新nacos 上的cloud-devops-gateway.yml 路由配置信息,此处会监听到更改,重新加载路由
            // 黑白名单url并未在此处增加监听,如有需要,可另外开启一个监听类
            configService.addListener(XegConstant.CONFIG_DATA_ID_DYNAMIC_ROUTES, nacosProperties.getGroup(), new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    log.info("更新网关路由开始");
                    updateRoute(configInfo);
                    log.info("更新网关路由完成");
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });

            configService.addListener(XegConstant.CONFIG_DATA_ID_COMMON, nacosProperties.getGroup(), new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    log.info("更新url黑白名单开始");
                    Yaml yaml = new Yaml();
                    UrlRule urlRule = yaml.loadAs(configInfo, UrlRule.class);
                    ApiProperties.updateUrlRule(urlRule.getRule());
                    log.info("更新url黑白名单完成");
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            log.error("加载路由出错：{}", e.getErrMsg());
        }
    }

    //更新网关路由规则
    public void updateRoute(String content) {
        Yaml yaml = new Yaml();
        GatewayRoute gatewayRoute = yaml.loadAs(content, GatewayRoute.class);
        gatewayRoute.getRoutes().forEach(route -> {
            log.info("加载路由：{},{}", route.getId(), route);
            routeDefinitionWriter.save(Mono.just(route)).subscribe();
        });
    }
}
