package pri.xcz.hp.infrastructure.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pri.xcz.hp.application.gateway.IdGateway;
import reactor.core.publisher.Mono;


@Component
public class IdGatewayImpl implements IdGateway {

    @Autowired
    private WebClient.Builder loadBalancedWebClientBuilder;

    @Value("${idg.genId.url}")
    private String genIdUrl;

    @Override
    public Mono<Long> nextId() {
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri(genIdUrl)
                .retrieve()
                .bodyToMono(Long.class);
    }
}
