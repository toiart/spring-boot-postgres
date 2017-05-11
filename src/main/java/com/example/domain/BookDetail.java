package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class BookDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookDetailId;

    private Integer numberOfPages;

    @JsonIgnore
    @OneToOne(mappedBy = "bookDetail")
    private Book book;

    public BookDetail() {
    }

    public Integer getBookDetailId() {
        return bookDetailId;
    }

    public void setBookDetailId(Integer bookDetailId) {
        this.bookDetailId = bookDetailId;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
