package com.example.mockAuth.dto;

public class SendOtpResponse {

    private String otp;

    public SendOtpResponse(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
