package com.example.bookstore.service.dto;

import java.util.Optional;

public class CustomerDto {

    private Long customerID;
    private CartDto cartDto;

    public CustomerDto(Long customerID, CartDto cartDto) {
        this.customerID = customerID;
        this.cartDto = cartDto;
    }

    public CartDto getCart() {
        return cartDto;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
}
