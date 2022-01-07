package com.xeg.cores.base.logger;

import cn.hutool.json.JSONUtil;
import com.xeg.cores.base.context.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author ArchieDing
 * @since 2020/09/07
 */
@Slf4j
@Aspect
@Component
public class SystemControllerLogAspect {
    private static final ThreadLocal<SystemLogDTO> LOG_THREAD_LOCAL = new NamedThreadLocal<SystemLogDTO>("SystemServiceLog ThreadLocal SystemLogDTO");

    @Resource
    private ISystemLogService systemLogService;

    @Pointcut("@annotation(com.xeg.cores.base.logger.SystemControllerLog)")
    public void systemControllerPointCut() {
        log.info("SystemControllerLogAspect.systemControllerPointCut()");
    }

    @Before("systemControllerPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("SystemControllerLogAspect.doBefore()");
        SystemControllerLog log = getAnnotationLog(joinPoint);
        if (log == null) {
            return;
        }
        SystemLogDTO logDTO = new SystemLogDTO();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logDTO.setType(log.type());
        logDTO.setValue(log.value());
        logDTO.setClassName(className);
        logDTO.setMethodName(methodName);
        logDTO.setParams(getRequestParams());
        logDTO.setStartTime(System.currentTimeMillis());
        logDTO.setCreateUser(UserHolder.getUserId().toString());
        LOG_THREAD_LOCAL.remove();
        LOG_THREAD_LOCAL.set(logDTO);
    }

    private String getRequestParams() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String[]> map = request.getParameterMap();
        return JSONUtil.toJsonStr(map);
    }

    @After("systemControllerPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("SystemControllerLogAspect.doAfter()");
        SystemLogDTO logDTO = LOG_THREAD_LOCAL.get();
        logDTO.setEndTime(System.currentTimeMillis());
        systemLogService.saveSystemLog(logDTO);
    }

    @AfterReturning(pointcut = "systemControllerPointCut()", returning = "result")
    public void afterReturning(Object result) {
        log.info("SystemControllerLogAspect.afterReturning() " + result.toString());
        SystemLogDTO logDTO = LOG_THREAD_LOCAL.get();
        logDTO.setResult(JSONUtil.toJsonStr(result));
        LOG_THREAD_LOCAL.set(logDTO);
    }

    private SystemControllerLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(SystemControllerLog.class);
        }
        return null;
    }
}
