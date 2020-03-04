package pri.xcz.hp.common;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebInputException;
import pri.xcz.hp.common.model.BaseError;
import pri.xcz.hp.common.model.BaseException;

import java.util.LinkedHashMap;
import java.util.Map;

public class GlobalErrorAttributes extends DefaultErrorAttributes {
    public GlobalErrorAttributes() {
        super(false);
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        return assembleError(request);
    }

    private Map<String, Object> assembleError(ServerRequest request) {
        Map<String, Object> em = new LinkedHashMap<>();
        Throwable error = getError(request);
        if (error instanceof BaseException) {
            BaseException e1 = (BaseException) error;
            em.put("ce", e1.getError());
        } else if (error instanceof ServerWebInputException) {
            ServerWebInputException e1 = (ServerWebInputException) error;
            BaseError e2 = new BaseError(-1, e1.getCause().getMessage(), HttpStatus.BAD_REQUEST.value());
            em.put("ce", e2);
        } else {
            BaseError e = new BaseError(-1, error.getMessage(), HttpStatus.BAD_REQUEST.value());
            em.put("ce", e);
        }
        return em;
    }
}
