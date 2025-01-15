package com.project1.CloudVendor.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, 
    Object responsObject){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", message);
        responseMap.put("HttpStatus", httpStatus);
        responseMap.put("data", responsObject);

        return new ResponseEntity<>(responseMap, httpStatus);
    }
}
