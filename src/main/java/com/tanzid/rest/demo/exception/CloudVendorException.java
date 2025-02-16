package com.tanzid.rest.demo.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException extends RuntimeException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public CloudVendorException(String message, HttpStatus httpStatus,Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
