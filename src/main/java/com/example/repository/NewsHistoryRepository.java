package com.example.repository;

import com.example.domain.NewsHistory;
import com.example.repository.keys.NewsHistoryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsHistoryRepository extends JpaRepository<NewsHistory, NewsHistoryKey> {

}