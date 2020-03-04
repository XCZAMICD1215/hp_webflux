package pri.xcz.hp.application.gateway;

import reactor.core.publisher.Mono;

public interface IdGateway {
    Mono<Long> nextId();
}
