package pri.xcz.hp.infrastructure.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;
import pri.xcz.hp.application.gateway.IdGateway;
import pri.xcz.hp.application.model.BullPo;
import pri.xcz.hp.application.repo.BullRepo;
import pri.xcz.hp.common.model.BaseErrors;
import pri.xcz.hp.common.model.BaseException;
import pri.xcz.hp.infrastructure.model.BullDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v0")
@AllArgsConstructor
public class BullController {

    private final BullRepo bullRepo;
    private final IdGateway idGateway;

    @PostMapping("/bull")
    public Mono<BullDto> create(@RequestBody BullDto dto) {
        return idGateway.nextId()
                .map(id -> BullPo.builder().id(id).name(dto.getName()).age(dto.getAge())
                        .createOn(System.currentTimeMillis()).lastModifyOn(System.currentTimeMillis()).build())
                .flatMap(bullRepo::save)
                .map(BullDto::new);
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
    public Mono<BullDto> findById(@PathVariable Long id) {
        return bullRepo.findById(id).map(BullDto::new);
    }

    @GetMapping("/err1")
    public Mono err1(){
        return Mono.error(new BaseException(BaseErrors.unknownError1));
    }

    @GetMapping("/err")
    public Mono err2(){
        return Mono.error(new BaseException(BaseErrors.unknownError2));
    }

}
