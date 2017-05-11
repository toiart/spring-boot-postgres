package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class News extends BaseDomain implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    private String content;

    @Enumerated(EnumType.STRING)
    private NewsStatus status;

    private java.sql.Timestamp expiredDate;

    @ManyToMany
    @JoinTable(name = "News_Channel",
            joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "newsId"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channelId"))
    private Set<Channel> channels = new HashSet<>();

    public News() {
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsStatus getStatus() {
        return status;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }

    public java.sql.Timestamp getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(java.sql.Timestamp expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", channel=" + channels +
                '}';
    }
}
