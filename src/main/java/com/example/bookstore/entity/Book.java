package com.example.bookstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a book table in the DB
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
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
    private String availableNumberOfCopies;


}
