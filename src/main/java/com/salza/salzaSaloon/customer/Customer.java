package com.salza.salzaSaloon.customer;


import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;

@Slf4j
@Entity
public class Customer {
    @Id
    private String email;
    private String firstname;
    private String lastname;
    private String phoneNumber;

    public Customer(){

    }

    public Customer(String email, String firstname, String lastname, String phoneNumber) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }
}
