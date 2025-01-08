package com.example.bookstore.service.dto;

import lombok.Builder;

@Builder
public class BookDto {

    private Long bookId;
    private String authorName;
    private String bookName;
    private int availableNumberOfCopies;
    private int price;

    public BookDto(Long bookId, String authorName, String bookName, int availableNumberOfCopies, int price ) {
        this.bookId = bookId;
        this.authorName = authorName;
        this.bookName = bookName;
        this.availableNumberOfCopies = availableNumberOfCopies;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAvailableNumberOfCopies() {
        return availableNumberOfCopies;
    }

    public void setAvailableNumberOfCopies(int availableNumberOfCopies) {
        this.availableNumberOfCopies = availableNumberOfCopies;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
