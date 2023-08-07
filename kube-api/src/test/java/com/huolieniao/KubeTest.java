package com.huolieniao;

import com.huolieniao.service.TalentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
}
