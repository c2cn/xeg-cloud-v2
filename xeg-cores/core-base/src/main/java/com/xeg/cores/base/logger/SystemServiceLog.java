package com.xeg.cores.base.logger;

import java.lang.annotation.*;

/**
 * @author ArchieDing
 * @since 2020/09/07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String type() default "SERVICE";

    String value() default "";
}
