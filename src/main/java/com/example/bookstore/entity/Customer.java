package com.example.bookstore.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a customer entity in the DB
 */

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerID;

    @Column(name = "customer_name")
    private String customerName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(nullable = true)
    public String password;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
