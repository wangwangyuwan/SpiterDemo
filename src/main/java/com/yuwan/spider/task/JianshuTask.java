package com.yuwan.spider.task;

import com.yuwan.spider.contants.CommonContants;
import com.yuwan.spider.task.downloader.HttpClientDownloader;
import com.yuwan.spider.task.processor.JianshuProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Spider;

@Configuration
@EnableScheduling
public class JianshuTask {
    @Scheduled(cron = "0 0 * * * ?")
    public void task() {
        Spider.create(new JianshuProcessor())
                .setDownloader(new HttpClientDownloader())
                .addUrl(CommonContants.HTTPS+CommonContants.DOMAIN_JIANSHU)
                .thread(1)
                .run();
    }
}
