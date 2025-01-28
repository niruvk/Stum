package com.example.stocksummarizer;
import java.io.IOException;
import java.util.ArrayList;

//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper{
    public static void main( String[] args ) throws IOException{
        String[] urls = new String[5];
        String ticker = "$BEP";
        String web = "https://news.google.com/search?q=" + ticker + "+stock" + "&num=5";
        Document doc = Jsoup.connect(web).get();
        Elements results = doc.select("div.xrnccd > article > h3 > a");
        int count = 0;
        for (Element result : results) {
            String linkHref = result.attr("abs:href");
            urls[count] = linkHref;

            String linkText = result.text();
            if (linkHref.startsWith("/url?q=")) {
                linkHref = linkHref.substring(7);
            }
            if (count == 4) {
                break;
            }

            count++;
        }

        for(String url : urls) {
            System.out.println(url);
            Document page = Jsoup.parse(url);
            Elements elements = page.select("div[class=class_name] p");
            String text = elements.text();
            System.out.println(text);

//
        }

//        for(String url : urls) {
//            doc = Jsoup.connect(url).get();
//            Element mainTextElement = doc.select("span").first();
//            String mainText = mainTextElement.text();
//            System.out.println(mainText);
//        }

//        for(String url : urls) {
//            doc = Jsoup.connect(url).followRedirects(true).get();
//            Element mainTextElement = doc.select("div.article-body").first();
//            String mainText = mainTextElement.text();
//            System.out.println(mainText);
//        }

//        for(String url : urls){
//            doc = Jsoup.connect(url).get();
//            Elements para = doc.select("spa");
//            for(Element p : para){
//                System.out.println(p.text());
//            }
//        }

//        for (String url : urls) {
////            doc = Jsoup.connect(url).get();
////            Elements paragraphs = doc.select("p");
////            if (paragraphs.isEmpty()) {
////                System.out.println("No paragraphs found on the page.");
////            }
////            StringBuilder sb = new StringBuilder();
////            for (Element p : paragraphs) {
////                sb.append(p.text()).append("\n");
////            }
//
//            doc = Jsoup.connect(url).get();
//            Element link = doc.select("a").first();
//            String abslink = link.attr("abs:href");
//            realUrl[index] = abslink;
//            index++;
//
//
//
//            // Print the main text
//
//        }
//
//        for(String url : realUrl){
//            doc = Jsoup.connect(url).get();
//            String text = doc.body().text();
//            System.out.println(text);
//        }
    }
}