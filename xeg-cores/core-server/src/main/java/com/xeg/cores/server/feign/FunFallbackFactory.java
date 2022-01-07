package com.xeg.cores.server.feign;

import feign.Target;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @program: xeg-cloud
 * @description:
 * @author: ArchieDing
 * @create: 2021-05-12 08:45
 **/
@AllArgsConstructor
public class FunFallbackFactory<T> implements FallbackFactory<T> {
    private final Target<T> target;

    @Override
    @SuppressWarnings("unchecked")
    public T create(Throwable cause) {
        final Class<T> targetType = target.type();
        final String targetName = target.name();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetType);
        enhancer.setUseCache(true);
        enhancer.setCallback(new FunFeignFallback<>(targetType, targetName, cause));
        return (T) enhancer.create();
    }
}
