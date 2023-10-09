package com.example.Filmland.service;


import com.example.Filmland.Repository.SubscriptionRepository;
import com.example.Filmland.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SchedulerService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Scheduled(cron = "0 0 0 * * ?") // this will run daily at midnight
    public void handleSubscriptionPayments() {
        Iterable<Subscription> allSubscriptions = subscriptionRepository.findAll();

        for (Subscription subscription : allSubscriptions) {
            if (subscription.getCustomer().getStartingPayDay().isEqual(LocalDate.now())) {
                // Handle payment logic here
                // You might want to deduct from user's balance, notify them,
                // deactivate their subscription if they don't have sufficient balance, etc.
            }
        }
    }
}
