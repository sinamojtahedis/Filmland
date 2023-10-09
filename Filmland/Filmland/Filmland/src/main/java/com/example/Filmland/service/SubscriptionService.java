package com.example.Filmland.service;

import com.example.Filmland.entity.Subscription;
import com.example.Filmland.request.ResponseDto;
import com.example.Filmland.request.ShareSubscriptionRequest;

import java.util.Optional;

public interface SubscriptionService {
    Iterable<Subscription> findAll();

    Optional<Subscription> findById(long id);

    void remove(long id);

    ResponseDto shareSubscription(ShareSubscriptionRequest request);


}
