package com.library.service;

import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        bookRepository.getAllBooks();
    }
}