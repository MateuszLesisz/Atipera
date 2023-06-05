package com.atipera.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NewExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GithubException.class)
    ResponseEntity<ErrorResponse> handleBusinessException(GithubException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(exception.getHttpStatus().value())
                        .message(exception.getMessage())
                        .build());
    }
}