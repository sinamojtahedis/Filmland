package com.example.Filmland.service;

import com.example.Filmland.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Optional<Customer> findCustomerByEmailAndPassword(String email, String password);

    Customer createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Optional<Customer> findCustomerById(Long id);


}
