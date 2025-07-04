package com.hotel_services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException resourceNotFoundException){
        Map map = new HashMap();
        map.put("message",resourceNotFoundException.getMessage());
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("success",false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
