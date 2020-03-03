package pri.xcz.hp.infrastructure.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pri.xcz.hp.application.repo.BullRepo;
import pri.xcz.hp.infrastructure.repo.BullRepoImpl;
import pri.xcz.hp.infrastructure.repo.ReactiveBullRepo;

@Configuration
public class DaoConfig {
    @Bean
    public BullRepo bullDao(ReactiveBullRepo bullRepo){
        return new BullRepoImpl(bullRepo);
    }
}
