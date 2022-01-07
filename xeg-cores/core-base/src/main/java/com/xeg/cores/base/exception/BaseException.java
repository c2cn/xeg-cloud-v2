package com.xeg.cores.base.exception;

import lombok.Getter;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
@Getter
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -7664761444665949080L;
    private String code;
    private Object[] args;
    private String message;

    public BaseException() {
    }

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, Object[] args, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.args = args;
    }

    public BaseException(String code, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.args = args;
        this.message = message;
    }
}
