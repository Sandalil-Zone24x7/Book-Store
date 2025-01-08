package com.example.bookstore.repository;

import com.example.bookstore.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c.cartId FROM Cart c WHERE c.customer.id = :id AND c.isActive = true")
    Long findCartIdOfCustomer(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.isActive = false WHERE c.id = :id")
    int setCartInactive(@Param("id") Long id);


}
