package com.minhvu.omapp.backend.exception;

import java.util.*;

public class ApiError {
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private Map<String, String> fieldErrors;

    public ApiError(int status, String message, String error, Map<String,  String> fieldErrors) {
        this.timestamp = new Date(System.currentTimeMillis());
        this.status = status;
        this.message = message;
        this.error = error;
        this.fieldErrors = fieldErrors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
