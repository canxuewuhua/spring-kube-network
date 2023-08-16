package com.huolieniao;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableApolloConfig
@EnableAsync
public class KubeApi {
    public static void main(String[] args) {
        SpringApplication.run(KubeApi.class, args);
    }
}