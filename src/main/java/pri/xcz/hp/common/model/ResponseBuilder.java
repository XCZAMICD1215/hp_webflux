package pri.xcz.hp.common.model;

public class ResponseBuilder {
    public static <T> Response<T> ok(T data) {
        return Response.<T>builder()
                .code(0)
                .message("")
                .build();
    }

    public static <T> Response<T> err(BaseError error) {
        return Response.<T>builder()
                .code(error.getCode())
                .message(error.getErrorMessage())
                .build();
    }
}
