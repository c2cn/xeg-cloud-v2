package com.xeg.cores.base.exception;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
public interface IResponseEnum {
    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误消息
     *
     * @return
     */
    String getMessage();
}
