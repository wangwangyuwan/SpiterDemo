package com.yuwan.spider.controller;

import com.yuwan.spider.contants.CommonContants;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class JianshuRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        page.putField("url",page.getUrl());

        List<String> all = page.getHtml().xpath("//a[@class='title']").all();
        List<String> details = new ArrayList<>();
        all.forEach(e->{
            details.add(CommonContants.ROOT_PATH+e);
        });

        page.addTargetRequests(details);

    }

    @Override
    public Site getSite() {
        return site;
    }


}
