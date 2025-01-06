package com.example.bookstore.services;

import com.example.bookstore.entity.Cart;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CartService cartService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CartService cartService) {
        this.customerRepository = customerRepository;
        this.cartService = cartService;
    }

    /**
     * Handles the creation of a customer
     * Creates an empty cart for the customer during the process
     */
    public Customer createCustomer(Customer customer) {
        Cart createdCart = cartService.createCart();
        Long id = customer.getCustomerID();
        return customerRepository.save(customer);

    }

    public Long getCartId(Long id) {
        return customerRepository.findCardIdOfCustomer(id);
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
