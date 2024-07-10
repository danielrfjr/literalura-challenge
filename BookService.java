package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface BookService {

    Book fetchBook(String title);

    List<Book> getAllBooks();

    void displayBooksByLanguageStatistics();
}
