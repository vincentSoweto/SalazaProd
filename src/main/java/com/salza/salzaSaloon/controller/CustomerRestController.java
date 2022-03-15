package com.salza.salzaSaloon.controller;

import com.salza.salzaSaloon.customer.Customer;
import com.salza.salzaSaloon.customer.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomerRestController {

    private final com.salza.salzaSaloon.customer.CustomerRepository CustomerRepository;
    public CustomerRestController(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
        this.CustomerRepository.saveAll(List.of(
                new Customer("aloo@gmail.com","jay","jay", "0815469789"),
                new Customer("aqeloo@gmail.com","jasday","jay", "0818969789"),
                new Customer("aloqweqwo@gmail.com","asd","jay", "0815555789"),
                new Customer("aqeloo@gmail.com","asd","ddy", "0815469445"),
                new Customer("aloasdo@gmail.com","jsdsday","jay", "0812648789"),
                new Customer("aaaloo@gmail.com","ddsjay","jay", "0816455889")
        ));
    }

    @GetMapping
    Iterable<Customer> getCustomers() {
        return CustomerRepository.findAll();
    }
    @GetMapping("/{id}")
    Optional<Customer> getCustomerById(@PathVariable String id) {
        return CustomerRepository.findById(id);
    }
    @PostMapping
    Customer postCustomer(@RequestBody Customer customer) {
        return CustomerRepository.save(customer);
    }
    @PutMapping("/{id}")
    ResponseEntity<Customer> putCustomer(@PathVariable String id,
                                         @RequestBody Customer customer) {
        return (!CustomerRepository.existsById(id))
                ? new ResponseEntity<>(CustomerRepository.save(customer),
                HttpStatus.CREATED)
                : new ResponseEntity<>(CustomerRepository.save(customer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable String id) {
        CustomerRepository.deleteById(id);
    }
}

