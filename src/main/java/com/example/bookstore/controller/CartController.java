package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The controller to handle endpoints related to a cart
 */
@RestController
@RequestMapping("api/v1/carts/")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping
    public void confirmCart() {

    }

    @GetMapping
    public void getCartTotalPrice() {

    }

    @GetMapping
    public void getCartItems(Long customerId) {

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
//        cartService.getCart(id);
//    }

}
