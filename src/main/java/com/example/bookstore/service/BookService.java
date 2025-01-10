package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.dto.BookDto;

import java.util.List;
import java.util.Optional;

/**
 * An interface defining the book service methods.
 */
public interface BookService {

    /**
     * Logic related to creating and saving a book to the database
     * @param bookDto
     * @return
     */
    BookDto createBook(BookDto bookDto);

    /**
     * Returns a list of books in the book store
     * @return
     */
    List<Book> getAllBooks();

    /**
     * Returns a book when an id is given
     * @param id
     * @return
     */
    Optional<Book> getBook(Long id);

    /**
     * Delete book by the id
     * @param id
     * @return
     */
    boolean deleteBookById(Long id);
}
