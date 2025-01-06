package com.example.bookstore.repository;

import com.example.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //A query to get the cart id of the customer
    @Query("SELECT c.cart_id FROM Cart c WHERE c.id = :id")
    public Long findCardIdOfCustomer(@Param("id") Long id);

}
