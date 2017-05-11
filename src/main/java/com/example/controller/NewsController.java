package com.example.controller;

import com.example.domain.News;
import com.example.domain.NewsHistory;
import com.example.domain.NewsStatus;
import com.example.repository.keys.NewsHistoryKey;
import com.example.service.NewsHistoryService;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    NewsHistoryService newsHistoryService;

    @GetMapping("/news")
    public ResponseEntity<Page<News>> getNewsList() {

        List<News> newsList = newsService.getNewsList();

        return new ResponseEntity(newsList, HttpStatus.OK);
    }

    @GetMapping("/news/channel/{id}/user/{userId}")
    public ResponseEntity<Page<News>> getNewsByChannel(@PathVariable Long id,
                                                        @PathVariable String userId,
                                                        @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC) Pageable pageable) {

        Page<News> newsList = newsService.getNewsByChannel(id, pageable);

        return new ResponseEntity(newsList, HttpStatus.OK);
    }

    @PostMapping("/news")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody News news) {
        newsService.saveNews(news);
    }


    @PutMapping("/news/{id}/user/{userId}/like")
    public ResponseEntity<Void> likeNews(@PathVariable Long id, @PathVariable String userId) {

        News news = newsService.getNews(id);
        if (news == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        newsHistoryService.saveNewsHistory(new NewsHistory(new NewsHistoryKey(id, userId, "like")));

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/news/{id}/user/{userId}/unlike")
    public ResponseEntity<Void> unLikeNews(@PathVariable Long id, @PathVariable String userId) {

        News news = newsService.getNews(id);
        if (news == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        NewsHistory newsHistory = newsHistoryService.getNewsHistory(new NewsHistoryKey(id, userId, "like"));
        if (newsHistory == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        newsHistoryService.deleteNewsHistory(newsHistory);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        News news = newsService.getNews(id);
        if (news == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        news.setStatus(NewsStatus.DELETED);
        newsService.saveNews(news);
        return new ResponseEntity(HttpStatus.OK);
    }
}
