package pri.xcz.hp.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseException extends RuntimeException {

    private BaseError error;

    public BaseException(BaseError err){
        super(err.getErrorMessage());
        this.error = err;
    }

}
