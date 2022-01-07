package com.xeg.cores.base.exception;


import com.xeg.cores.base.exception.enums.ThrowCommonException;

import java.text.MessageFormat;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(ThrowCommonException.ANY_ERROR.getCode(), message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }

    public ServiceException(IResponseEnum responseEnum) {
        super(responseEnum.getCode(), responseEnum.getMessage());
    }

    public ServiceException(IResponseEnum responseEnum, Object... args) {
        super(responseEnum.getCode(), args, MessageFormat.format(responseEnum.getMessage(), args));
    }

    public ServiceException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum.getCode(), args, message, cause);
    }
}
