package com.yuwan.spider.task.processor;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class JianshuProcessor implements PageProcessor {

    private static final Site site = Site.me().setRetryTimes(3).setTimeOut(3000);

    @Override
    public void process(Page page) {
        Selectable xpath = page.getHtml().xpath("//div[@class='content']");

    }

    @Override
    public Site getSite() {
        return site;
    }
}
