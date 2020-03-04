package pri.xcz.hp.common;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import pri.xcz.hp.common.model.BaseError;
import pri.xcz.hp.common.model.ResponseBuilder;
import reactor.core.publisher.Mono;

import java.util.Map;

public class GlobalErrorHandlerConf extends AbstractErrorWebExceptionHandler {

    public GlobalErrorHandlerConf(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, applicationContext);
    }

    public GlobalErrorHandlerConf(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext, ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, resourceProperties, applicationContext);
        this.setMessageReaders(serverCodecConfigurer.getReaders());
        this.setMessageWriters(serverCodecConfigurer.getWriters());
    }


    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderResponse);
    }

    private Mono<ServerResponse> renderResponse(ServerRequest serverRequest) {
        Map<String, Object> em = getErrorAttributes(serverRequest, false);
        return Mono.justOrEmpty(em.get("ce"))
                .flatMap(e -> {
                    BaseError e1 = (BaseError) e;
                    return ServerResponse.status(((BaseError) e).getHttpCode())
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromObject(ResponseBuilder.err(e1)));
                });
    }
}
