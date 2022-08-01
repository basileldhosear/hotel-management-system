package com.meetup.hotel_management_system.exception;

public class BusinessException extends Exception{

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
