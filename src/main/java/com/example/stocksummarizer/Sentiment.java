package com.example.stocksummarizer;

public class Sentiment {
    private String sentimentName;
    private int sentimentInt;

    public Sentiment(String sentimentName, int sentimentInt) {
        this.sentimentName = sentimentName;
        this.sentimentInt = sentimentInt;
    }

    public String getSentimentName() {
        return sentimentName;
    }

    public int getSentimentInt() {
        return sentimentInt;
    }
}