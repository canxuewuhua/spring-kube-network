package com.huolieniao;

import com.huolieniao.service.RedissonService;
import com.huolieniao.service.TalentService;
import com.huolieniao.spi.SpiService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KubeTest extends BaseTest{


    @Autowired
    private TalentService talentService;
//    @Autowired
//    private RedissonService redissonService;
    @Autowired
    private SpiService spiService;

    @Test
    public void testTalentIndex(){
        talentService.buildTalentIndex();
    }

    @Test
    public void testQueryTalentEntity(){
        talentService.queryTalentEntity();
    }

//    @Test
//    public void testRedissonService(){
//        redissonService.businessHandler();
//    }

    @Test
    public void testSPI(){
        spiService.load();
    }
}
