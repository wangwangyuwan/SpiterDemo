package com.yuwan.spider;

import com.yuwan.spider.contants.CommonContants;
import com.yuwan.spider.controller.JianshuRepoPageProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Spider;

@SpringBootApplication
public class SpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
        runJianshuProcessor();
    }
    public static void runJianshuProcessor(){

        Spider.create(new JianshuRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl(CommonContants.ROOT_PATH+"/search?q=%E5%B0%8F%E7%A8%8B%E5%BA%8F&page=1&type=note")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

}
