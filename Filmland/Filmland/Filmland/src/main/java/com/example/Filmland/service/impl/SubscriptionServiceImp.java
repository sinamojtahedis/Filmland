package com.example.Filmland.service.impl;

import com.example.Filmland.Repository.CategoryRepository;
import com.example.Filmland.Repository.CustomerRepository;
import com.example.Filmland.Repository.SubscriptionRepository;
import com.example.Filmland.entity.Category;
import com.example.Filmland.entity.Customer;
import com.example.Filmland.entity.Subscription;
import com.example.Filmland.request.ResponseDto;
import com.example.Filmland.request.ShareSubscriptionRequest;
import com.example.Filmland.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class SubscriptionServiceImp implements SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Iterable<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findById(long id) {
        return subscriptionRepository.findById(id);
    }


    @Override
    public void remove(long id) {
        subscriptionRepository.deleteById(id);

    }

    @Override
    public ResponseDto shareSubscription(ShareSubscriptionRequest request) {
        Customer originalCustomer = customerRepository.findByEmail(request.getEmail());
        Customer customerToShareWith = customerRepository.findByEmail(request.getCustomer());
        Category category = categoryRepository.findByName(request.getSubscribedCategory())
                .orElse(null);

        if (originalCustomer == null || customerToShareWith == null || category == null) {
            return new ResponseDto("Login failed", "Customer or category not found.");
        }

        Subscription subscription = subscriptionRepository.findByCustomerAndCategory(originalCustomer, category)
                .orElse(null);
        if (subscription == null) {
            return new ResponseDto("Login failed", "The given category is not subscribed by the original customer.");
        }

        Subscription newSubscription = new Subscription(subscription.getMaxLimit(), true, customerToShareWith, category);
        subscriptionRepository.save(newSubscription);

        return new ResponseDto("Login successful", "Subscription shared successfully.");
    }

}
