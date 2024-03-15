package com.customer.Exceptions;

public class ApiRequestNotFoundException extends RuntimeException{
    public ApiRequestNotFoundException(String message) {
        super(message);
    }

    public ApiRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
