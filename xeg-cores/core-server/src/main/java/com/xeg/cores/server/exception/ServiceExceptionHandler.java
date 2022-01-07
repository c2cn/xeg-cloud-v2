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
@RestControllerAdvice(basePackages = "com.xeg.servers")
public class ServiceExceptionHandler {

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
        System.out.println("service：businessExceptionHandler...");
        log.info("service：businessExceptionHandler...");
        ServiceException be = (ServiceException) e;
       return JsonResultUtils.error(be.getCode(),be.getMessage());
    }


}
