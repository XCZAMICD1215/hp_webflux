package pri.xcz.hp.application.repo;

import pri.xcz.hp.application.model.BullPo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BullRepo {
    Mono<BullPo> save(BullPo entity);

    Mono<BullPo> update(BullPo entity);

    Flux<BullPo> findAll();

    Mono<BullPo> findById(Long id);
}
