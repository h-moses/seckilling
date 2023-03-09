package ms.seckilling.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result SUCCESS(SecKillStateEnum secKillStateEnum) {
        return new Result(secKillStateEnum.getState(), secKillStateEnum.getMessage());
    }

    public static Result FAILURE(SecKillStateEnum secKillStateEnum) {
        return new Result(secKillStateEnum.getState(), secKillStateEnum.getMessage());
    }
}
