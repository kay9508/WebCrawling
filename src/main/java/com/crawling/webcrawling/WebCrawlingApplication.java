package com.crawling.webcrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebCrawlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlingApplication.class, args);
        // 일반 크롤링
        /*Document doc = Jsoup.connect("https://velog.io/@minjiki2/posts").get();
        Document naverSearch = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=3&acq=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80&qdt=0&ie=utf8&query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80%EC%83%89").get();
        Document naverSearch2 = Jsoup.connect("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EA%B5%AC%EA%B8%80&oquery=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B2%80%EC%83%89&tqi=iVjQ7sqo15wssPkmFb4ssssssxK-286521").get();
        Document danawaSearch = Jsoup.connect("https://prod.danawa.com/info/?pcode=41449034").get();
        System.out.println(doc.title());*/


        // 셀레니움 동적 크롤링
        // Chrome WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "D:/chrome/chromedriver-win64/chromedriver.exe");

        // Chrome 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 헤드리스 모드 (선택사항)

        // WebDriver 초기화
        WebDriver driver = new ChromeDriver(options);

        try {
            // 웹사이트 접속
            driver.get("https://prod.danawa.com/info/?pcode=41449034");

            // 페이지 로딩 대기 (필요에 따라 조정)
            Thread.sleep(2000);

            // 원하는 요소 찾기 및 데이터 추출
            WebElement element = driver.findElement(By.id("productDescriptionArea"));
            String text = element.getText();
            driver.close(); //원하는 정보를 가져왔기 때문에 driver를 종료한다.
            System.out.println("추출된 텍스트: " + text);

            String releaseYear = text.substring(text.indexOf("출시년도") + 5, text.indexOf("출시년도") + 9);
            String doorCount = text.substring(text.indexOf("도어") + 3, text.indexOf("도어") + 6);
            String totalCapacity = text.substring(text.indexOf("총용량") + 4, text.indexOf("총용량") + 8);

            System.out.println("출시년도 :" + releaseYear.strip());
            System.out.println("도어수 :" + doorCount.strip());
            System.out.println("총용량 :" + totalCapacity.strip());


            // 더 많은 크롤링 로직 추가...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }

}
