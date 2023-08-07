package com.huolieniao.service;

import com.huolieniao.domain.TalentEntity;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TalentService {

    @Resource
    private ElasticsearchRestTemplate restTemplate;

    public void buildTalentIndex(){
        restTemplate.delete("myTalent");
        TalentEntity talentEntity = new TalentEntity();
        talentEntity.setId(1L);
        talentEntity.setName("张三丰A");
        talentEntity.setAddr("北京市朝阳区");
        TalentEntity talentEntity1 = new TalentEntity();
        talentEntity1.setId(2L);
        talentEntity1.setName("张五级");
        talentEntity1.setAddr("北京市昌平区");
        List<TalentEntity> list = new ArrayList<>();
        list.add(talentEntity);
        list.add(talentEntity1);
        restTemplate.save(list);
    }
}
