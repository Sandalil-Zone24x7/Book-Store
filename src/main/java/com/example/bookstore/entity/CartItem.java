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

}
