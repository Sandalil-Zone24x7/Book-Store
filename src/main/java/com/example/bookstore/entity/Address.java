package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an address entity in the DB
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    @Column(nullable = true)
    private String number;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String area;

    @Column(nullable = true, name = "postal_code")
    private Integer postalCode;

    @Column(nullable = true)
    private String country;



}
