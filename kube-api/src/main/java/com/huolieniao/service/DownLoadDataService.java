package com.huolieniao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@Slf4j
public class DownLoadDataService {

    @Autowired
    private AsynchronousService asynchronousService;

    public void executeDownLoad(){
        log.info("当前时间：{}, begin execute download data...", new Date());
        asynchronousService.springAsynchronousMethod();
        log.info("当前时间：{}, execute end", new Date());
    }
}
