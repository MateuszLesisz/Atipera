package com.atipera.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GithubException extends RuntimeException {
    private final HttpStatus status;

    protected GithubException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}