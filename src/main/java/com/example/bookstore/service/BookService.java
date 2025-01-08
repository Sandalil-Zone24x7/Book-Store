package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.dto.BookDto;

import java.util.List;
import java.util.Optional;

/**
 * An interface defining the book service methods.
 */
public interface BookService {

    BookDto createBook(BookDto bookDto);

    List<Book> getAllBooks();

    Optional<Book> getBook(Long id);

    boolean deleteBookById(Long id);
}
