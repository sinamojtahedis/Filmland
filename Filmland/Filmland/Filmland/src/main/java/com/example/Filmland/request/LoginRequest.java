package com.example.Filmland.request;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class LoginRequest {
    private String email;
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}