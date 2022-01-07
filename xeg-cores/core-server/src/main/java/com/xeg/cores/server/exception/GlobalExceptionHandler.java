package com.xeg.cores.server.exception;

import com.xeg.cores.base.exception.ServiceException;
import com.xeg.cores.base.exception.enums.ThrowCommonException;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BindException.class)
    public Object handleValidationBeanException(Exception e) {
        BindException be = (BindException) e;
        log.error("[GlobalExceptionHandler][handleValidationBeanException] exception", e);
//        throw new ServiceException(ThrowCommonException.VALID_ERROR.getCode(), be.getFieldError().getDefaultMessage());
        return JsonResultUtils.error(ThrowCommonException.VALID_ERROR.getCode(), be.getFieldError().getDefaultMessage());
    }

    /**
     * 业务异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public Object businessExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("[GlobalExceptionHandler][businessExceptionHandler] exception", e);
        ServiceException be = (ServiceException) e;
//        throw new ServiceException(be.getCode(), be.getMessage());
        return JsonResult.error(be.getCode(), be.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object noHandlerFoundExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("[GlobalExceptionHandler][noHandlerFoundExceptionHandler] exception", e);
//        throw new ServiceException(ThrowCommonException.PAGE_NOT_FOUND.getCode(), ThrowCommonException.PAGE_NOT_FOUND.getMessage());
        return JsonResult.error(ThrowCommonException.PAGE_NOT_FOUND.getCode(), ThrowCommonException.PAGE_NOT_FOUND.getMessage());
    }


    /**
     * 全局异常处理
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("[GlobalExceptionHandler][exceptionHandler] exception", e);
//        throw new ServiceException(ThrowCommonException.SERVER_ERROR.getCode(), ThrowCommonException.SERVER_ERROR.getMessage());
        return JsonResult.error(ThrowCommonException.SERVER_ERROR.getCode(), ThrowCommonException.SERVER_ERROR.getMessage());
    }
}
