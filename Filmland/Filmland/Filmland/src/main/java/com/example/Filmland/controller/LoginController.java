package com.example.Filmland.controller;

import com.example.Filmland.request.LoginRequest;
import com.example.Filmland.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class LoginController {

    @Autowired
    private CustomerService customerService;
//http://localhost:8080/api/login
//{
    //   "email": "info@filmland-assessment.nl",
    //       "password": "Javaiscool90"
//}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (customerService.findCustomerByEmailAndPassword(request.getEmail(), request.getPassword()).isPresent()) {
            return ResponseEntity.ok("Login was successful");
        } else {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }


}
