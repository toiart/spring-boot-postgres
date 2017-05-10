package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Art on 11/24/16.
 */
@Entity
public class BookDetail {

    private Integer bookDetailId;
    private Integer numberOfPages;
    private Book book;

    public BookDetail() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @OneToOne(mappedBy = "bookDetail")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
