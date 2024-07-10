package com.example.service;

import com.example.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    List<Author> getLivingAuthorsInYear(int year);
}
