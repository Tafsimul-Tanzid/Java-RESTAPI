package com.tanzid.rest.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CloudVendorExceptionHandle {
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object>handleCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException)
    {

        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                cloudVendorNotFoundException.getCause()
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }

      // Handle other exceptions like DuplicateCloudVendorException
      @ExceptionHandler(DuplicateCloudVendorException.class)
      public ResponseEntity<Map<String, Object>> handleDuplicateCloudVendorException(DuplicateCloudVendorException ex) {
          Map<String, Object> response = new HashMap<>();
          response.put("error", "Cloud Vendor already exists.");
          response.put("message", ex.getMessage());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
      }

}
