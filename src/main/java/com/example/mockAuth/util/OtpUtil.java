package com.example.mockAuth.util;

import java.security.SecureRandom;

import java.security.SecureRandom;

public class OtpUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateOtp() {
        int otp = 100000 + RANDOM.nextInt(900000); // 6-digit
        return String.valueOf(otp);
    }
}
