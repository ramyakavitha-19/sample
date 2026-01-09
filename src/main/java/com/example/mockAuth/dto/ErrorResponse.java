package com.example.mockAuth.dto;

public class ErrorResponse {

    private ErrorStatus status;

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}
