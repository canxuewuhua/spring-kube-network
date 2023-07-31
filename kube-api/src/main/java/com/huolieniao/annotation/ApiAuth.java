package com.huolieniao.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiAuth {

    // 默认值
    String value() default "";

    String country() default "中国";
}
