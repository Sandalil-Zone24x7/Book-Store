package com.example.bookstore.service;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.dto.CartDto;

public interface CartService {

    void createCart(Customer customer);

    CartDto getCartItems(Long id);

    Boolean confirmCart(Long id);

}
