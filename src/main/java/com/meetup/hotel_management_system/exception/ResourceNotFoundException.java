package com.meetup.hotel_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{


    public ResourceNotFoundException(String message) {
        super(message); // Post not found with id : 1

    }

}
