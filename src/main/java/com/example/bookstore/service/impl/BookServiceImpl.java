package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.dto.BookDto;
import com.example.bookstore.service.helper.BookHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookHelper bookHelper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookHelper bookHelper) {
        this.bookRepository = bookRepository;
        this.bookHelper = bookHelper;
    }

    public BookDto createBook(BookDto bookDto) {
        Book bookEntity = bookHelper.convertToBook(bookDto);
        Book createdBook = bookRepository.save(bookEntity);
        return bookHelper.convertToBookDto(createdBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public boolean deleteBookById(Long id) {

        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
