package com.huolieniao;

import com.huolieniao.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KubeTest extends BaseTest{


    @Autowired
    private TalentService talentService;

    @Test
    public void testTalentIndex(){
        talentService.buildTalentIndex();
    }

    @Test
    public void testQueryTalentEntity(){
        talentService.queryTalentEntity();
    }
}
