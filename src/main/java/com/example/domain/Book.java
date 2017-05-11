package com.example.domain;

import javax.persistence.*;

@Entity
public class Book {

    private Integer bookId;
    private String bookName;
    private BookDetail bookDetail;

    public Book() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id")
    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", booktName='" + bookName + '\'' +
                ", bookDetail=" + bookDetail +
                '}';
    }
}
