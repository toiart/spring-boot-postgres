package com.example.repository.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NewsHistoryKey implements Serializable {

    @Column(nullable = false)
    Long newsId;

    @Column(nullable = false)
    String userId;

    @Column(nullable = false)
    String newsType;

    public NewsHistoryKey() {
    }

    public NewsHistoryKey(Long newsId, String userId, String newsType) {
        this.newsId = newsId;
        this.userId = userId;
        this.newsType = newsType;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
}
