package com.salza.salzaSaloon;

import com.salza.salzaSaloon.customer.Customer;
import com.salza.salzaSaloon.customer.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.List;

public class DataLoader {
    private final com.salza.salzaSaloon.customer.CustomerRepository CustomerRepository;
    public DataLoader(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }
    @PostConstruct
    private void loadData() {
        CustomerRepository.saveAll(List.of(
                new Customer("aladoo@gmail.com","jay","jay", "0815469789"),
                new Customer("asdad@gmail.com","jasday","jay", "0818969789"),
                new Customer("aloqsdsdweqwo@gmail.com","asd","jay", "0815555789")

                ));
    }
}
