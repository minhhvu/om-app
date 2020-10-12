package com.minhvu.omapp.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IDNotFoundException extends ResponseStatusException {
    public IDNotFoundException(String model, Long id) {
        super(HttpStatus.NOT_FOUND, model + " with ID of "+ id.toString() + " is not found");
    }

    public IDNotFoundException(String model, String message){
        super(HttpStatus.NOT_FOUND, model + ": " + message);
    }
}
