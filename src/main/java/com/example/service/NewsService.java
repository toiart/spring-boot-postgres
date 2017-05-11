package com.example.service;

import com.example.domain.News;
import com.example.domain.NewsStatus;
import com.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public News getNews(Long newsId) {
        return newsRepository.findOne(newsId);
    }

    public Page<News> getNewsByChannel(Long id, Pageable pageable) {
        return newsRepository.findNewsByChannel(id, pageable);
    }

    public List<News> getNewsList() {
        return newsRepository.findByExpiredDateGreaterThanAndStatusIn(new Date(), NewsStatus.ACTIVE, NewsStatus.INACTIVE);
    }

    public void saveNews(News news) {
        newsRepository.save(news);
    }
}
