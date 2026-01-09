package com.example.mockAuth.service;

import com.example.mockAuth.dto.ErrorMessage;
import com.example.mockAuth.dto.ErrorResponse;
import com.example.mockAuth.dto.ErrorStatus;

import java.util.Collections;

public class ErrorUtil {

    private ErrorUtil() {
        // Prevent object creation
    }

    public static ErrorResponse unauthorized() {

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage_TYPE("BE");
        errorMessage.setMessageCode("100");
        errorMessage.setMessageDesc("The user is not authorized to perform the action.");

        ErrorStatus status = new ErrorStatus();
        status.setMessage(Collections.singletonList(errorMessage));

        ErrorResponse response = new ErrorResponse();
        response.setStatus(status);

        return response;
    }
}

