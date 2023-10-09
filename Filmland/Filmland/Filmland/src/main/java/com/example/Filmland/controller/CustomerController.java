package com.example.Filmland.controller;


import com.example.Filmland.entity.Customer;
import com.example.Filmland.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;


    //http://localhost:8080/api/customer/all
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return this.customerService.findAllCustomers();
    }

    // http://localhost:8080/api/customer/create
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerService.createCustomer(customer);
    }

    @PostMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
        this.customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        this.customerService.deleteCustomer(id);
    }

    //http://localhost:8080/api/get/1
    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
