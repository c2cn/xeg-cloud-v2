package com.xeg.devops.gateway.handler;

import cn.hutool.core.util.StrUtil;
import com.xeg.cores.base.exception.enums.ThrowCommonException;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


/**
 * 异常处理通知
 *
 * @author pangu
 */
@Slf4j
@Component
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = {ResponseStatusException.class})
    public JsonResult<T> handle(ResponseStatusException ex) {
        log.error("response status exception:{}", ex.getMessage());
        if (StrUtil.contains(ex.getMessage(), HttpStatus.NOT_FOUND.toString())) {
            return JsonResultUtils.error(ThrowCommonException.PAGE_NOT_FOUND);
        } else {
            return JsonResultUtils.error(ThrowCommonException.SERVER_ERROR);
        }
    }

    @ExceptionHandler(value = {ConnectTimeoutException.class})
    public JsonResult<T> handle(ConnectTimeoutException ex) {
        log.error("connect timeout exception:{}", ex.getMessage());
        return JsonResultUtils.error(ThrowCommonException.SERVER_ERROR);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonResult<T> handle(NotFoundException ex) {
        log.error("not found exception:{}", ex.getMessage());
        return JsonResultUtils.error(ThrowCommonException.PAGE_NOT_FOUND);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<T> handle(RuntimeException ex) {
        log.error("runtime exception:{}", ex.getMessage());
        return JsonResultUtils.error(ThrowCommonException.SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<T> handle(Exception ex) {
        log.error("exception:{}", ex.getMessage());
        return JsonResultUtils.error(ThrowCommonException.SERVER_ERROR);
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<T> handle(Throwable throwable) {
        JsonResult result = null;
        if (throwable instanceof ResponseStatusException) {
            result = handle((ResponseStatusException) throwable);
        } else if (throwable instanceof ConnectTimeoutException) {
            result = handle((ConnectTimeoutException) throwable);
        } else if (throwable instanceof NotFoundException) {
            result = handle((NotFoundException) throwable);
        } else if (throwable instanceof Exception) {
            result = handle((Exception) throwable);
        }
        return result;
    }
}
