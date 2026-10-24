package com.registration.event_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(
            RuntimeException exception) {

        String message = exception.getMessage();

        HttpStatus status;

        if ("Email is already registered".equals(message)) {
            status = HttpStatus.CONFLICT;
        } else if ("Event is full".equals(message)) {
            status = HttpStatus.CONFLICT;
        } else if ("Registration not found".equals(message)) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(status)
                .body(Map.of("message", message));
    }
}
