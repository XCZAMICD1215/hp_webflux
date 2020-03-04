package pri.xcz.hp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    private Integer code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
