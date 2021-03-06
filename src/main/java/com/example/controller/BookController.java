package com.example.controller;

import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/books")
    public List<Book> getBooks() {
        return bookService.getBookList();
    }

    @PostMapping(path = "/book")
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String bookId) {

        try {
            Book book = bookService.getBook(new Integer(bookId));
            if (book == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(book, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") String bookId) {

        try {
            if (bookService.getBook(new Integer(bookId)) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            bookService.deleteBook(new Integer(bookId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
