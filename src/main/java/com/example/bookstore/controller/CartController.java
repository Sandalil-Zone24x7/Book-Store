package com.example.bookstore.controller;

import com.example.bookstore.service.CartService;
import com.example.bookstore.service.dto.CartDto;
import com.example.bookstore.service.impl.CartServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The controller to handle endpoints related to a cart
 */
@RestController
@RequestMapping("api/v1/carts/")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartService = cartServiceImpl;
    }

    @PatchMapping ("/confirm/{id}")
    public ResponseEntity<Boolean> confirmCart(@PathVariable("id") Long id) {
        try{
            Boolean confirmed = cartService.confirmCart(id);
            return ResponseEntity.ok(confirmed);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<CartDto> getCartItems(@PathVariable("id") Long cartId) {

        try {
            CartDto cartDto = cartService.getCartItems(cartId);
            return ResponseEntity.ok(cartDto);
        } catch (EntityNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

}
