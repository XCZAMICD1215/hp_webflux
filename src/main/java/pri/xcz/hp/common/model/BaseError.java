package pri.xcz.hp.common.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BaseError {
    private Integer code;
    private String errorMessage;
    private Integer httpCode;
}
