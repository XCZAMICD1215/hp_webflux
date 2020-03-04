package pri.xcz.hp.infrastructure.repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pri.xcz.hp.application.model.BullPo;
import pri.xcz.hp.application.repo.BullRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class BullRepoImpl implements BullRepo {

    private final ReactiveBullRepo repo;

    @Override
    public Mono<BullPo> save(BullPo entity) {
        entity.setNa(true);
        return repo.save(entity);
    }

    @Override
    public Mono<BullPo> update(BullPo entity) {
        entity.setNa(false);
        return repo.save(entity);
    }

    @Override
    public Flux<BullPo> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<BullPo> findById(Long id) {
        return repo.findById(id);
    }
}
