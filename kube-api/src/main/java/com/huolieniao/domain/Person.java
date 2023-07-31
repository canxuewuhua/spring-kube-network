package com.huolieniao.domain;

import com.huolieniao.annotation.Gender;
import com.huolieniao.annotation.Name;
import com.huolieniao.annotation.Profile;
import lombok.Data;

@Data
public class Person {

    @Name("张三丰")
    private String name;

    @Gender(gender = Gender.GenderType.MALE)
    private String sex;

    @Profile(height = 180, weight = 80, address = "北京市")
    private String profile;
}
