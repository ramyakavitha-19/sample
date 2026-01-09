package com.example.mockAuth.dto;

import java.util.List;

public class ErrorStatus {

    private List<ErrorMessage> message;

    public List<ErrorMessage> getMessage() {
        return message;
    }

    public void setMessage(List<ErrorMessage> message) {
        this.message = message;
    }
}
