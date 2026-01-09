package com.example.mockAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String type;
    private String clid;
    private String sec;
    private String bank_id;
    private String username;
    private String password;
    private String ip_address;

    // getters & setters
}

