package com.example.stocksummarizer;

import java.util.ArrayList;

public class Article {

    private String title;
    private ArrayList<String> summary;

    private String summaryText;
    private Sentiment sentiment;

    public Article(String title, ArrayList<String> summary) {
        this.title = title;
        this.summary = summary;
        System.out.println("Title: " + title);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < summary.size(); i++) {
            //System.out.println(summary.get(i));
            stringBuilder.append(summary.get(i));
        }
        summaryText = stringBuilder.toString();
        /*this.sentiment = nlpPipeline.estimateSentiment(summaryText.toString());
        System.out.println(sentiment.getSentimentName());
        System.out.println(sentiment.getSentimentInt());*/
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getSummary() {
        return summary;
    }

    public Sentiment getSentiment() {
        return sentiment;
    }

    public String getSummaryText() {
        return summaryText;
    }
}
