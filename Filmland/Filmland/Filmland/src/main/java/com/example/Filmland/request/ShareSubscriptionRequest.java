package com.example.Filmland.request;

import lombok.Data;

@Data
public class ShareSubscriptionRequest {
    private String email; // original subscriber
    private String customer; // customer to share with
    private String subscribedCategory;
}