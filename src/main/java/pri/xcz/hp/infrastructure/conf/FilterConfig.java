package pri.xcz.hp.infrastructure.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import pri.xcz.hp.infrastructure.filter.AuditRecorder;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
public class FilterConfig {

    @Order(HIGHEST_PRECEDENCE)
    @Bean
    public AuditRecorder auditRecorder() {
        return new AuditRecorder();
    }
}
