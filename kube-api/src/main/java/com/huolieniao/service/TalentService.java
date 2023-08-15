package com.huolieniao.service;

import com.google.common.base.Throwables;
import com.huolieniao.domain.TalentEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

    /**
     * 注意点：分页是从0开始！
     * totalHits 总查询量
     * searchHits 分页数据
     */
    public void queryTalentEntity(){
        try{
            // BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
            QueryBuilder term = QueryBuilders.termQuery("name.keyword", "张三丰A");
            // 分页 从0开始 一页10条数据
            NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(term).withPageable(PageRequest.of(0, 10));
            FieldSortBuilder builder = new FieldSortBuilder("id").order(SortOrder.DESC);
            nativeSearchQueryBuilder.withSort(builder);
            NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
            String[] includeFields = {"id","name","addr"};
            nativeSearchQuery.addSourceFilter(new FetchSourceFilter(includeFields, null));
            nativeSearchQuery.setTrackTotalHits(Boolean.TRUE);

            SearchHits<TalentEntity> searchResult = restTemplate.search(nativeSearchQuery, TalentEntity.class);
            log.info("talent entity 查询->{},sort:{}", nativeSearchQuery.getQuery(), nativeSearchQuery.getElasticsearchSorts());
            if (!CollectionUtils.isEmpty(searchResult.getSearchHits())) {
                for (SearchHit<TalentEntity> account : searchResult) {
                    TalentEntity content = account.getContent();
                    System.out.println(content);
                }
            }
        }catch (Exception e){
            log.error("访问es出现异常，异常信息：{}", Throwables.getStackTraceAsString(e));
        }
    }
}
