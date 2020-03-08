package pri.xcz.hp.infrastructure.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
public class AuditRecorder implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        String path = serverWebExchange.getRequest().getURI().getPath();
        if (legalPath(path)) {
            log.info("serve {}", path);
        }
        return webFilterChain.filter(serverWebExchange);
    }

    private Boolean legalPath(String path) {
        return path.startsWith("/v");
    }
}
