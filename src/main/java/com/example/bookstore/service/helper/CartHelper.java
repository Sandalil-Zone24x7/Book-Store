package com.example.bookstore.service.helper;


import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.CartItem;
import com.example.bookstore.service.dto.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartHelper {

    public CartDto convertToCartDto(Optional<List<CartItem>> cartItems, Cart cart) {

        return new CartDto(cart.getCartId(), cart.getCustomerId(), cartItems);
    }

}
