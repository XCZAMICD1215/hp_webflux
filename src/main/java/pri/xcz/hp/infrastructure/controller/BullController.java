package pri.xcz.hp.infrastructure.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;
import pri.xcz.hp.application.model.BullPo;
import pri.xcz.hp.application.repo.BullRepo;
import pri.xcz.hp.infrastructure.model.BullDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v0")
@AllArgsConstructor
public class BullController {

    private final BullRepo bullRepo;

    @PostMapping("/bull")
    public Mono<BullDto> create(@RequestBody BullDto dto) {
        BullPo pojo1 = BullPo.builder().id(generateId()).name(dto.getName()).age(dto.getAge())
                .createOn(System.currentTimeMillis()).lastModifyOn(System.currentTimeMillis()).build();
        return bullRepo.save(pojo1).map(BullDto::new);
    }

    @PutMapping("/bull")
    public Mono<BullDto> update(@RequestBody BullDto dto) {
        return bullRepo.findById(dto.getId())
                .map(x -> x.toBuilder().name(dto.getName()).age(dto.getAge()).lastModifyOn(System.currentTimeMillis()).build())
                .flatMap(bullRepo::update)
                .map(BullDto::new);
    }


    @GetMapping("/bull")
    public Flux<BullDto> findAll() {
        return bullRepo.findAll().map(BullDto::new);
    }

    @GetMapping("/bull/{id}")
    public Mono<BullDto> findById(@PathVariable Integer id) {
        return bullRepo.findById(id).map(BullDto::new);
    }

    private Integer generateId() {
        return RandomUtils.nextInt();
    }
}
