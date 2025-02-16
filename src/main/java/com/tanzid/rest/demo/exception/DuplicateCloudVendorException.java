package com.tanzid.rest.demo.exception;

public class DuplicateCloudVendorException extends RuntimeException {
    public DuplicateCloudVendorException(String message) {
        super(message);
    }
}
