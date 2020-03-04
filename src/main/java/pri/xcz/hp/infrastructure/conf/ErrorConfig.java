package pri.xcz.hp.infrastructure.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import pri.xcz.hp.common.GlobalErrorAttributes;
import pri.xcz.hp.common.GlobalErrorHandlerConf;

@Configuration
public class ErrorConfig {

    @Bean
    @Order(-2)
    @ConditionalOnMissingBean(ErrorWebExceptionHandler.class)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ResourceProperties resourceProperties,
                                                             ApplicationContext applicationContext,
                                                             ServerCodecConfigurer serverCodecConfigurer) {
        return new GlobalErrorHandlerConf(new GlobalErrorAttributes(), resourceProperties, applicationContext,
                serverCodecConfigurer);
    }
}
