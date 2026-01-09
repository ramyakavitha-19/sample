package com.example.mockAuth.dto;

public class ErrorMessage {

    private String message_TYPE;
    private String messageCode;
    private String messageDesc;

    public String getMessage_TYPE() {
        return message_TYPE;
    }

    public void setMessage_TYPE(String message_TYPE) {
        this.message_TYPE = message_TYPE;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }
}
