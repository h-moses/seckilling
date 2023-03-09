package ms.seckilling.api;

public enum SecKillStateEnum {

    MUCH(2,"哎呦喂，人也太多了，请稍后！"),
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATE_REWRITE(-3,"数据篡改");

    private Integer state;

    private String message;

    SecKillStateEnum(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SecKillStateEnum stateOf(int index) {
        for (SecKillStateEnum state:
             values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
