package com.insurflow.user.exception;

import com.insurflow.user.payload.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotResourceException(ResourcesNotFoundException ex){
        ApiResponse<?> response=ApiResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .build();
        return  ResponseEntity.badRequest().body(response);
    }
}
