package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.dto.CustomerDto;
import com.example.bookstore.service.impl.CustomerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The controller for the endpoints related to customer.
 */
@RestController
@RequestMapping("api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {

        this.customerService = customerServiceImpl;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        boolean isDeleted = customerService.deleteCustomerById(id);
        if (isDeleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {

        try{
            CustomerDto customerDto = customerService.getCustomerToDisplay(id);
            return ResponseEntity.ok(customerDto);
        } catch (EntityNotFoundException e) {
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}

