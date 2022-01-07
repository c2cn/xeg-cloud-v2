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

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author ArchieDing
 * @since 2020/09/07
 */
@Slf4j
@Aspect
@Component
public class SystemServiceLogAspect {
    private static final ThreadLocal<SystemLogDTO> LOG_THREAD_LOCAL = new NamedThreadLocal<SystemLogDTO>("SystemServiceLog ThreadLocal SystemLogDTO");

    @Resource
    private ISystemLogService systemLogService;

    @Pointcut("@annotation(com.xeg.cores.base.logger.SystemServiceLog)")
    public void systemServicePointCut() {
        log.info("SystemServiceLogAspect.systemServicePointCut()");
    }

    @Before("systemServicePointCut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("SystemServiceLogAspect.doBefore()");
        SystemServiceLog log = getAnnotationLog(joinPoint);
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
        logDTO.setParams(getMethodParams(joinPoint));
        logDTO.setStartTime(System.currentTimeMillis());
        logDTO.setCreateUser(UserHolder.getUserId().toString());
        LOG_THREAD_LOCAL.remove();
        LOG_THREAD_LOCAL.set(logDTO);
    }

    private String getMethodParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return JSONUtil.toJsonStr(args);
    }

    @After("systemServicePointCut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("SystemServiceLogAspect.doAfter()");
        SystemLogDTO logDTO = LOG_THREAD_LOCAL.get();
        logDTO.setEndTime(System.currentTimeMillis());
        systemLogService.saveSystemLog(logDTO);
    }

    @AfterReturning(pointcut = "systemServicePointCut()", returning = "result")
    public void afterReturning(Object result) {
        if (null == result) {
            return;
        }
        log.info("SystemServiceLogAspect.afterReturning() " + result.toString());
        SystemLogDTO logDTO = LOG_THREAD_LOCAL.get();
        logDTO.setResult(JSONUtil.toJsonStr(result));
        LOG_THREAD_LOCAL.set(logDTO);
    }

    private SystemServiceLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(SystemServiceLog.class);
        }
        return null;
    }
}
