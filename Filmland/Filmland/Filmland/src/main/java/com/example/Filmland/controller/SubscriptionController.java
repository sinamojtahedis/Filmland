package com.example.Filmland.controller;

import com.example.Filmland.Repository.CategoryRepository;
import com.example.Filmland.Repository.CustomerRepository;
import com.example.Filmland.Repository.SubscriptionRepository;
import com.example.Filmland.entity.Category;
import com.example.Filmland.entity.Customer;
import com.example.Filmland.entity.Subscription;
import com.example.Filmland.request.ResponseDto;
import com.example.Filmland.request.ShareSubscriptionRequest;
import com.example.Filmland.request.SubscribeRequest;
import com.example.Filmland.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CustomerRepository customerRepository;


    // http://localhost:8080/api/subscription

    @GetMapping(value = "subscription", produces = "application/json")
    public Iterable<Subscription> getAllSubscription() {


        return subscriptionService.findAll();

    }

    // http://localhost:8080/api/subscription/1

    @GetMapping(value = "subscription/{id}", produces = "application/json")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable long id) {
        Optional<Subscription> subscription = subscriptionService.findById(id);

        if (subscription.isPresent()) {
            return ResponseEntity.ok().body(subscription.get());
        }

        return ResponseEntity.notFound().build();
    }


    // http://localhost:8080/api/subscriptionDel/2
    @DeleteMapping("subscriptionDel/{id}")
    public ResponseEntity<Void> deleteSubscriptionById(@PathVariable long id) {
        subscriptionService.remove(id);
        return ResponseEntity.ok().build();
    }
   // {
     //   "email": "OriginalEmail",
    //        "customer": "customerToShare",
   //         "subscribedCategory": "Dutch Films"
 //   }
    //http://localhost:8080/api/share
    @PostMapping("/share")
    public ResponseDto shareSubscription(@RequestBody ShareSubscriptionRequest request) {
        return subscriptionService.shareSubscription(request);
    }

    //http://localhost:8080/api/subscribeToCategory
    //{
    //    "email": "info@filmland-assessment.nl",
    //    "availableCategory": "Dutch Films"
    //}
    @PostMapping("/subscribeToCategory")
    public ResponseEntity<ResponseDto> subscribeToCategory(@RequestBody SubscribeRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail());

        if (customer == null) {
            return ResponseEntity.badRequest().body(new ResponseDto("Login failed", "Customer not found."));
        }

        Optional<Category> categoryOptional = categoryRepository.findByName(request.getAvailableCategory());

        if (!categoryOptional.isPresent()) {
            return ResponseEntity.badRequest().body(new ResponseDto("Login failed", "Category not found."));
        }

        Category category = categoryOptional.get();

        Optional<Subscription> existingSubscription = subscriptionRepository.findByCustomerAndCategory(customer, category);

        if (existingSubscription.isPresent()) {
            return ResponseEntity.badRequest().body(new ResponseDto("Login failed", "Already subscribed to this category."));
        }

        Subscription newSubscription = new Subscription(null, true, customer, category);
        subscriptionRepository.save(newSubscription);

        return ResponseEntity.ok(new ResponseDto("Login successful", "Successfully subscribed to the category."));
    }
}
