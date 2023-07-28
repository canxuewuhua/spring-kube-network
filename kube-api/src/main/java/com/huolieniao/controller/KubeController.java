package com.huolieniao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kube")
@Slf4j
public class KubeController {

    @Value("${kube.msg}")
    private String kubeMsg;

    @GetMapping("msg")
    public String getKubeMsg(){
        log.info("getKubeMsg 方法 日志打印....");
        return kubeMsg;
    }
}
