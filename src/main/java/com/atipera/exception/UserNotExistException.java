package com.atipera.exception;

import org.springframework.http.HttpStatus;

public class UserNotExistException extends GithubException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.NOT_FOUND;

    public UserNotExistException(String username) {
        super(String.format("User with given username does not exist.", username), DEFAULT_HTTP_STATUS);
    }
}