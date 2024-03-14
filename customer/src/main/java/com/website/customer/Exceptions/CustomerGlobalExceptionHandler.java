package com.website.customer.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomerGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiCustomerException> handleException(ApiRequestNotFoundException exception) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        ApiCustomerException customerErrorData = new ApiCustomerException(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(customerErrorData, badRequest);
    }
}
