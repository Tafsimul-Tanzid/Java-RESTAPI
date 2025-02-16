package com.tanzid.rest.demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public  static ResponseEntity<Object>responseBuilder(
            String message, HttpStatus httpStatus, Object responseObject
    )
    {
        Map<String,Object> response =new HashMap<>();
        response.put("message",message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);


        return  new ResponseEntity<>(response,httpStatus);

    }
    // DoubleResponseHandler without response data
    public static ResponseEntity<Map<String, Object>> DoubleResponseHandler(
            String message, HttpStatus httpStatus
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }
}
