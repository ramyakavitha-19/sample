package com.example.mockAuth.controller;

import com.example.mockAuth.dto.*;
import com.example.mockAuth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apg/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Object response = authService.login(request);

        if (response instanceof ErrorResponse) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sendotp")
    public ResponseEntity<?> sendOtp(
            @RequestHeader("Authorization") String authorization,
            @RequestBody SendOtpRequest request) {

        Object response = authService.sendOtp(authorization, request);

        if (response instanceof ErrorResponse) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return ResponseEntity.ok(response);
    }

}
