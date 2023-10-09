package com.example.Filmland.service.impl;

import com.example.Filmland.Repository.CustomerRepository;
import com.example.Filmland.entity.Customer;
import com.example.Filmland.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);

    }

    @Override
    public Optional<Customer> findCustomerByEmailAndPassword(String email, String password) {
        Optional<Customer> foundCustomer = Optional.ofNullable(customerRepository.findByEmail(email));
        if (foundCustomer.isPresent() && passwordEncoder.matches(password, foundCustomer.get().getPassword())) {
            return foundCustomer;
        }
        return Optional.empty();
    }


}



