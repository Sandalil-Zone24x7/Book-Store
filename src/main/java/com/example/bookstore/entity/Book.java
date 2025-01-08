package com.example.bookstore.entity;


import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a book table in the DB
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    private int price;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "available_number_of_copies")
    private int availableNumberOfCopies;

    public Book(Long bookId, String bookName, int price, String authorName, int availableNumberOfCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.authorName = authorName;
        this.availableNumberOfCopies = availableNumberOfCopies;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAvailableNumberOfCopies() {
        return availableNumberOfCopies;
    }

    public void setAvailableNumberOfCopies(int availableNumberOfCopies) {
        this.availableNumberOfCopies = availableNumberOfCopies;
    }
}
