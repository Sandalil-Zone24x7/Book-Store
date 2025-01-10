package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.CartItem;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.CartItemRepository;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.dto.CartDto;
import com.example.bookstore.service.helper.CartHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartHelper cartHelper;

    @Autowired
    public CartServiceImpl(CartItemRepository cartItemRepository,
                           CartRepository cartRepository, CartHelper cartHelper) {

        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.cartHelper = cartHelper;
    }

    public void createCart(Customer customer) {

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        newCart.setCustomerId(customer.getCustomerID());
        System.out.println(newCart.getCustomerId());
        cartRepository.save(newCart);
    }

    /**
     * Get a list of cart items when the id is given.
     * @param id
     * @return
     */
    public CartDto getCartItems(Long id) {

        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()) {
            throw new EntityNotFoundException("Cart is empty");
        } else {
            Cart cart = optionalCart.get();
            Optional<List<CartItem>> cartItems = cartItemRepository.findAllByCartId(cart.getCartId());
            return cartHelper.convertToCartDto(cartItems, cart);
        }
    }

    /**
     * Set the cart as inactive when a cart is confirmed and order is placed.
     * @param cartId
     * @return
     */
    public Boolean confirmCart(Long cartId) {

        int affectedRows = cartRepository.setCartInactive(cartId);
        if( affectedRows == 0) {
            throw new EntityNotFoundException("Cart not found");
        } else {
            return true;
        }

    }

}
