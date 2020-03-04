package pri.xcz.hp.common;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pri.xcz.hp.common.model.BaseException;
import pri.xcz.hp.common.model.Response;
import pri.xcz.hp.common.model.ResponseBuilder;
import reactor.core.publisher.Mono;


//业务异常, 定制状态码
//@RestControllerAdvice
public class GlobalErrorHandlerAno {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Mono<Response> handle(BaseException e) {
        return Mono.just(ResponseBuilder.err(e.getError()));
    }

}
