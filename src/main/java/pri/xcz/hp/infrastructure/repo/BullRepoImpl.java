package pri.xcz.hp.infrastructure.repo;

import lombok.AllArgsConstructor;
import pri.xcz.hp.application.model.BullPo;
import pri.xcz.hp.application.repo.BullRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<BullPo> findById(Integer id) {
        return repo.findById(id);
    }
}
