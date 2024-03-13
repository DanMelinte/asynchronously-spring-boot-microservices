package com.website.customer.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiCustomerException { // necesar info about customer exceptions
    private String info;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public ApiCustomerException(String info, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.info = info;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    //    public CustomerErrorData() {
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
}
