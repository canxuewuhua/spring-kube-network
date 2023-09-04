package com.huolieniao.spi;

public class FileSearch implements Search{
    @Override
    public String getSearchContent(String content) {
        System.out.println("文件搜索: " + content);
        return "文件搜索: " + content;
    }
}
