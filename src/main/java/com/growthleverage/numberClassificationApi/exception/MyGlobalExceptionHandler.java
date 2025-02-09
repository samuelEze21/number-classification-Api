package com.growthleverage.numberClassificationApi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(InvalidNumberException.class)
    public ResponseEntity<Map<String, String>> handleInvalidNumberException(InvalidNumberException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        return ResponseEntity.internalServerError().body(Map.of("error", "An error occurred while processing your request."));
    }
}


