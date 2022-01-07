package com.xeg.cores.server;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * @program: service-demo-domain
 * @description:
 * @author: ArchieDing
 * @create: 2021-04-08 14:56
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Autowired
public @interface FeignReference {
}
