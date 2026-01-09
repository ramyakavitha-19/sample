package com.example.mockAuth.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String tokenType;
    private String token;
    private int expiresIn;
    private UserDto user;

    // getters & setters
}

