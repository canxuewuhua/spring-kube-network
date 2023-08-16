package com.huolieniao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AsynchronousService {

    @Async
    public void springAsynchronousMethod(){
        log.info("当前时间：{}", new Date());
        try{
            TimeUnit.MINUTES.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("execute async method......");
    }
}
