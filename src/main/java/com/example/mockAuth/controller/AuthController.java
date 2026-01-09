package com.example.mockAuth.controller;

import com.example.mockAuth.dto.ErrorResponse;
import com.example.mockAuth.dto.LoginRequest;
import com.example.mockAuth.dto.LoginResponse;
import com.example.mockAuth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apg/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Object response = authService.login(request);

        // ❌ Error case
        if (response instanceof ErrorResponse) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }

        // ✅ Success case
        return ResponseEntity.ok(response);
    }
}
