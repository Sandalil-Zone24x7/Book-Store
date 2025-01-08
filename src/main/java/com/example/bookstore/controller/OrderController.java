package com.example.bookstore.controller;

import com.example.bookstore.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller class to handle endpoints related to orders
 */
@RestController
@RequestMapping("api/v1/orders/")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/{id}")
    public Integer getTotal(@PathVariable Long id) {
        return orderServiceImpl.getOrderTotal(id);
    }

}
