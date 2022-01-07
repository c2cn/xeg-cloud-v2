package com.xeg.apps.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ArchieDing
 * @since 2020/09/08
 */
@Data
@Component
@ConfigurationProperties(prefix = "rule")
@RefreshScope
public class AuthProperties {
    private List<String> initWhitelist;
}
