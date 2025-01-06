package com.example.bookstore.services;

import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.CartItemRepository;
import com.example.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CustomerService customerService;

    @Autowired
    public CartService(CartItemRepository cartItemRepository, CartRepository cartRepository,
                       CustomerService customerService) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerService = customerService;
    }

    public Cart createCart() {
        Cart newCart = new Cart();
        return cartRepository.save(newCart);
    }


}
