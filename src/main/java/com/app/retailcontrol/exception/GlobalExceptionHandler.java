package com.app.retailcontrol.exception;

import com.app.retailcontrol.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Object>> handleJsonParseException(HttpMessageNotReadableException exception){
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                exception.getMessage(),
                "error",
                400,
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException exception) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                exception.getMessage(),
                "error",
                404,
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceAlreadyExists(ResourceAlreadyExistsException exception) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                exception.getMessage(),
                "error",
                409,
                null
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAnyException(Exception exception) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                "Unexpected error occurred",
                "error",
                500,
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

}
