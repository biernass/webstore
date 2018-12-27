package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Customer;
import com.mbsoft.webstore.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerDatabaseServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        Iterable<Customer> products = customerRepository.findAll();
        return StreamSupport.stream(products.spliterator(), true)
                .collect(Collectors.toList());
    }
}
