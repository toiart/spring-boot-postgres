package com.example.service;

import com.example.model.Book;
import com.example.model.Product;
import com.example.repository.BookRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Art on 11/24/16.
 */
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book getBook(Integer bookId) {
        return bookRepository.findOne(bookId);
    }

    public List<Book> getBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer bookId) {
        bookRepository.delete(bookId);
    }
}
