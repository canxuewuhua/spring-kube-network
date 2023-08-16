package com.huolieniao.service;

import com.alibaba.fastjson2.JSON;
import com.huolieniao.domain.Addr;
import com.huolieniao.domain.SingleSwitch;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取单个值  读取list字符串   读取list对象集合
 */
//@Configuration
@Data
public class ApolloConfig {


    @Value("${apollo.addr}")
    private String addr;

    @Value("${order.storeIds}")
    private List<String> storeList;

    private Map<String, SingleSwitch> allSwithchMap;

    private Addr address;

    @Value("${store.switch}")
    public void setAllSwitch(String params) {
        allSwithchMap = new HashMap<>();
        List<SingleSwitch> singleSwitchList = JSON.parseArray(params, SingleSwitch.class);
        for (SingleSwitch singleSwitch : singleSwitchList) {
            allSwithchMap.put(singleSwitch.getName(), singleSwitch);
        }
    }

    @Value("${store.info}")
    public void setAddr(String param){
        address = JSON.parseObject(param, Addr.class);
    }
}
