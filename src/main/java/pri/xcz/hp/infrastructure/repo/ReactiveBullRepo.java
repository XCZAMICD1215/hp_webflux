package pri.xcz.hp.infrastructure.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pri.xcz.hp.application.model.BullPo;

public interface ReactiveBullRepo extends ReactiveCrudRepository<BullPo, Long> {
}
