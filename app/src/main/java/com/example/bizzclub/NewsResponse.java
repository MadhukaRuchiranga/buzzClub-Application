package com.example.bizzclub;

import java.util.List;

public class NewsResponse {
    private List<NewsItem> news;

    public List<NewsItem> getNews() {
        return news;
    }

    public void setNews(List<NewsItem> news) {
        this.news = news;
    }
}
