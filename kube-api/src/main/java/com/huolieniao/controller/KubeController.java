package com.huolieniao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kube")
public class KubeController {

    @Value("${kube.msg}")
    private String kubeMsg;

    @GetMapping("msg")
    public String getKubeMsg(){
        return kubeMsg;
    }
}
