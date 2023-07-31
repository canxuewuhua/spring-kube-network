package com.huolieniao.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {

    int height() default 175;

    int weight() default 75;

    String address() default "";
}
