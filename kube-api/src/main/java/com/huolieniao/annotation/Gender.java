package com.huolieniao.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {


    @Getter
    @AllArgsConstructor
    enum GenderType{
        MALE("男性"),
        FEMALE("女性"),
        OTHER("中性");
        private String genderType;

    }

    GenderType gender() default GenderType.MALE;
}
