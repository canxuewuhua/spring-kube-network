package com.huolieniao;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KubeApi.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BaseTest {

    @Before
    public void init() {
        log.info("----------------KubeApi 测试开始---------------");
    }

    @After
    public void after() {
        log.info("----------------KubeApi 测试结束---------------");
    }
}
