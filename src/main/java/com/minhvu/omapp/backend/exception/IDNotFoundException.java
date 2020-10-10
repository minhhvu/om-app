package com.minhvu.omapp.backend.exception;

import javassist.NotFoundException;

public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String model, Long id) {
        super(model + " with ID of "+ id.toString() + " is not found");
    }

    public IDNotFoundException(Throwable cause) {
        super(cause);
    }

    public IDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
