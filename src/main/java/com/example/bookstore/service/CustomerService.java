package com.example.bookstore.service;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.dto.CustomerDto;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    CustomerDto getCustomerToDisplay(Long id);

    boolean deleteCustomerById(Long id);
}
