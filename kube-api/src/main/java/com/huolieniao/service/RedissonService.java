package com.huolieniao.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class RedissonService {

    @Autowired
    RedissonClient redissonClient;

    public void businessHandler(){
        log.info("开始执行");
        RLock lock = redissonClient.getLock("lock");
        try{
            // 阻塞式等待 默认加的锁是30秒时间 每10秒检查一次  续到30秒
            lock.lock();
            log.info("redis加锁执行业务中....");
            // 执行业务
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            log.info("业务执行完毕！！！");
        }
    }


}
