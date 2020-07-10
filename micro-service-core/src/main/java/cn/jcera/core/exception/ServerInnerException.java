package cn.jcera.core.exception;

public class ServerInnerException extends CommonException {

    private String bizLogicMsg;

    private Exception causeException;

    public ServerInnerException(Object data, String bizLogicMsg, Exception causeException) {
        super(data);
        this.bizLogicMsg = bizLogicMsg;
        this.causeException = causeException;
    }

}
