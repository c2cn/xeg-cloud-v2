package com.xeg.cores.server.feign;

import com.xeg.cores.base.exception.enums.ThrowCommonException;
import com.xeg.cores.base.http.JsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @program: xeg-cloud
 * @description:
 * @author: ArchieDing
 * @create: 2021-05-12 08:39
 **/
@Slf4j
@AllArgsConstructor
public class FunFeignFallback<T> implements MethodInterceptor {
    private final Class<T> targetType;
    private final String targetName;
    private final Throwable cause;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String errorMessage = cause.getMessage();
        log.error("FunFeignFallback:[{}.{}] serviceId:[{}] message:[{}]", targetType.getName(), method.getName(), targetName, errorMessage);
        log.error(cause.getMessage());
        //此处只是示例，具体可以返回带有业务错误数据的对象
        return JsonResult.error(ThrowCommonException.FEIGN_ERROR.getCode(), cause.getMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FunFeignFallback<?> that = (FunFeignFallback<?>) o;
        return targetType.equals(that.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetType);
    }
}