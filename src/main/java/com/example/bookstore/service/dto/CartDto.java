package com.example.bookstore.service.dto;

import com.example.bookstore.entity.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CartDto {

    private Long cartId;
    private Long customerId;
    private Optional<List<CartItem>> cartItemList;

    public CartDto(Long cartId, Long customerId, Optional<List<CartItem>> cartItemList) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.cartItemList = cartItemList;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Optional<List<CartItem>> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(Optional<List<CartItem>> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
