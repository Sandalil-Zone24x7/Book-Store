package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a cart item table in the DB
 * A cart item contains the book id and the number of the books added to the cart
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cartItem")
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int quanity;

    @Column(name = "cart_item_price")
    private int cartItemPrice;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(int cartItemPrice) {

        this.cartItemPrice = cartItemPrice;
    }
}
