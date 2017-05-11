package com.example.domain;

import com.example.repository.keys.NewsHistoryKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class NewsHistory implements Serializable {

    @EmbeddedId
    public NewsHistoryKey newsHistoryKey;

    public NewsHistory() {
    }

    public NewsHistory(NewsHistoryKey newsHistoryKey) {
        this.newsHistoryKey = newsHistoryKey;
    }
}
