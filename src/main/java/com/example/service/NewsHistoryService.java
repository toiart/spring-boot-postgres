package com.example.service;

import com.example.domain.NewsHistory;
import com.example.repository.NewsHistoryRepository;
import com.example.repository.keys.NewsHistoryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsHistoryService {

    @Autowired
    NewsHistoryRepository newsHistoryRepository;

    public NewsHistory getNewsHistory(NewsHistoryKey newHistoryKey) {
        return newsHistoryRepository.findOne(newHistoryKey);
    }

    public void saveNewsHistory(NewsHistory newsHistory) {
        newsHistoryRepository.save(newsHistory);
    }

    public void deleteNewsHistory(NewsHistory newsHistory) {
        newsHistoryRepository.delete(newsHistory);
    }
}
