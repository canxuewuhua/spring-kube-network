package com.huolieniao.spi;

import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.ServiceLoader;

@Service
public class SpiService {


    public void load(){
        ServiceLoader<Search> searches = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = searches.iterator();
        while (iterator.hasNext()){
            Search next = iterator.next();
            next.getSearchContent("welcome to Java");
        }
    }
}
