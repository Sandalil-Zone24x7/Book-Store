package com.example.bookstore.service.helper;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookHelper {

    public BookDto convertToBookDto(Book book) {

        return new BookDto(book.getBookId(), book.getAuthorName(), book.getBookName()
                ,book.getAvailableNumberOfCopies(), book.getPrice());

    }

    public Book convertToBook(BookDto bookDto) {

        return new Book(bookDto.getBookId(), bookDto.getBookName(),
                bookDto.getPrice(), bookDto.getAuthorName(), bookDto.getAvailableNumberOfCopies());

    }
}
