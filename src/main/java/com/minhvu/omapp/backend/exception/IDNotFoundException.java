package com.minhvu.omapp.backend.exception;

import javassist.NotFoundException;

public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String message) {
        super(message);
    }

    public IDNotFoundException(Throwable cause) {
        super(cause);
    }

    public IDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
