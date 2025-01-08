package com.example.bookstore.service.helper;

import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.dto.CartDto;
import com.example.bookstore.service.dto.CustomerDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerHelper {

    private CartService cartService;

    public CustomerHelper(CartService cartService) {
        this.cartService = cartService;
    }

    public CustomerDto convertToDisplayCustomer(Customer customer) {

        Cart cart = customer.getCart();
        Long cartId = cart.getCartId();
        CartDto cartDto = cartService.getCartItems(cart.getCartId());
        if(cartDto == null) {
            throw new EntityNotFoundException("Cart not found for the customer id : " + customer.getCustomerID());
        }else {
            return new CustomerDto(customer.getCustomerID(), cartDto);
        }

    }

}

