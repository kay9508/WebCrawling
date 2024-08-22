package com.crawling.webcrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebCrawlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlingApplication.class, args);
        try {
            Document doc = Jsoup.connect("https://velog.io/@minjiki2/posts").get();
            Document naverSearch = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=3&acq=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80&qdt=0&ie=utf8&query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80%EC%83%89").get();
            Document naverSearch2 = Jsoup.connect("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EA%B5%AC%EA%B8%80&oquery=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80%EC%83%89&tqi=iVjQ7sqo15wssPkmFb4ssssssxK-286521").get();
            Document naverSearch3 = Jsoup.connect("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EC%9D%B4%EC%A0%84%EA%B2%80%EC%83%89%EA%B8%B0%EB%A1%9D%EB%82%A8%EB%82%98%3F&oquery=%EA%B5%AC%EA%B8%80&tqi=iVjEBlqo15wssPcWi1wssssssyG-310087").get();
            System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
