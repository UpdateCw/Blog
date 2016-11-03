package com.update.framework.common;

/**
 * @author cw
 * @date 2016年10月21日
 * @vsersion 1.0
 * DOTO (自定义异常)
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -8146548931613321148L;

    public CustomException() {
        super();
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
