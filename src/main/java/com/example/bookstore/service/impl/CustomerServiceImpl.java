package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.dto.CustomerDto;
import com.example.bookstore.service.helper.CustomerHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CartService cartService;
    private final CustomerHelper customerHelper;

    /**
     * @param customerRepository
     * @param cartServiceImpl
     */
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CartServiceImpl cartServiceImpl,
                               CustomerHelper customerHelper) {

        this.customerHelper = customerHelper;
        this.customerRepository = customerRepository;
        this.cartService = cartServiceImpl;
    }

    /**
     * Handles the creation of a customer
     * Creates an empty cart for the customer during the process
     */
    public Customer createCustomer(Customer customer) {

        Customer createdCustomer = customerRepository.save(customer);
        cartService.createCart(createdCustomer);
        return createdCustomer;
    }

    /**
     * Creates and returns a customer object with the cart details to display.
     * @param id
     * @return
     */

    public CustomerDto getCustomerToDisplay(Long id){

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
            throw new EntityNotFoundException("Customer not found for the customer id : " + id);
        }else {
            Customer customer = optionalCustomer.get();
            return customerHelper.convertToDisplayCustomer(customer);

        }
    }
    /**
     * Handles the deletion of a customer record
     * @param id
     * @return deleted or not
     */
    public boolean deleteCustomerById(Long id) {

        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
