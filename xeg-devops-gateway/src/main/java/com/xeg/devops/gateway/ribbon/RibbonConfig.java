package com.xeg.devops.gateway.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Description //配置ribbon
 * @Author Qi Ding
 * @Date 2020/11/5 9:31 上午
 * @Version 1.0
 */
@Configuration
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonConfig {
}
