package com.example.stocksummarizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Locale;

public class MarketWatchScraper {

    public static void scrape(String ticker) throws IOException {
        Summarizer summarizer = new Summarizer();
        String url = "https://www.marketwatch.com/investing/stock/" + ticker;
        String[] urls = new String[5];
        String[] articles = new String[5];
        String[] titles = new String[5];
        Document doc = Jsoup.connect(url).get(); //Retrieves HTML Content of Url
        Element companyNameElement = doc.selectFirst("h1.company__name");
        String companyName = companyNameElement.text(); //pulls company name
        String[] companyNameWords = companyName.split(" ");
        String finderWord = companyNameWords[0];
        int count = 0;
        //For Loop Continuously Takes the Urls for News Articles from MarketWatch
        for (Element news : doc.select("div.article__content")) {
            try {
                Element link = news.selectFirst("a[href]");
                String newsUrl = link.attr("href");
                if(newsUrl.toLowerCase().contains(url.toLowerCase()))
                    throw new Exception();
                urls[count] = newsUrl;
//                System.out.println(newsUrl);
                count++;
                if (count == 5) { //First 5 Urls only are selected
                    break;
                }
            } catch(Exception e) {
                continue;
            }
        }
        count = 0;
        //Retrieves the main text from each of the urls
        for (String link : urls) {
            doc = Jsoup.connect(link).get();
            Element titleElement = doc.selectFirst("h1.article__headline");
            String title;
            if(titleElement != null)
                title = titleElement.text();
            else
                title = "Title Not Found";
            Element mainTextElement = doc.selectFirst("div.article__body");
            String mainText = mainTextElement.text();
            articles[count] = mainText;
            titles[count] = title;
            String[] splitText = mainText.split("(?<=[.!?])\\s+");
            String cleanedArticle = "";
            for (String sentence : splitText) {
                if (sentence.contains(ticker) || sentence.contains(finderWord))
                    cleanedArticle += sentence;
            }
            count++;
            GraphicsController.addArticle(new Article(title, summarizer.Summarize(cleanedArticle, 3)));
        }
    }
}

