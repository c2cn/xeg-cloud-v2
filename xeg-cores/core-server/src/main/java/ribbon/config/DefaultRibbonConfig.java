package ribbon.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Qi Ding
 * @Date 2020/11/5 8:53 上午
 * @Version 1.0
 */
@Configuration
public class DefaultRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new NacosFinalRule();
    }
}
