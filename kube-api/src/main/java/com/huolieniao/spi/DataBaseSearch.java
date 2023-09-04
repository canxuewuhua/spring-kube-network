package com.huolieniao.spi;

public class DataBaseSearch implements Search{
    @Override
    public String getSearchContent(String content) {
        System.out.println("数据库搜索：" + content);
        return "数据库搜索：" + content;
    }
}
