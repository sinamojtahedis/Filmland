package com.example.Filmland.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeRequest {
    private String email;
    private String availableCategory;
}