package com.growthleverage.numberClassificationApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class MyGlobalExceptionHandler {

        @ExceptionHandler(InvalidNumberException.class)
        public ResponseEntity<String> handleInvalidNumberException(InvalidNumberException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGenericException(Exception ex) {
            return new ResponseEntity<>("Internal Server Error. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//@RestControllerAdvice
//public class MyGlobalExceptionHandler {
//
//    @ExceptionHandler(InvalidNumberException.class)
//    public ResponseEntity<Map<String, String>> handleInvalidNumberException(InvalidNumberException ex) {
//        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
//        return ResponseEntity.internalServerError().body(Map.of("error", "An error occurred while processing your request."));
//    }
//}


