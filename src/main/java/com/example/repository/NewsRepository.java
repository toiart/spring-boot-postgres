package com.example.repository;

import com.example.model.News;
import com.example.model.NewsStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("select distinct n from News n join n.channels c where c.channelId = :channelId and n.status = 'ACTIVE'")
    Page<News> findNewsByChannel(@Param("channelId") Long id, Pageable pageable);

    List<News> findByExpiredDateGreaterThanAndStatusIn(Date today, NewsStatus ...status);
}