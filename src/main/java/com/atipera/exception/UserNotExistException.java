package com.atipera.exception;

import org.springframework.http.HttpStatus;

public class UserNotExistException extends GithubException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public UserNotExistException(String nickname) {
        super(String.format("User with nickname exist. {nickname=%s}", nickname), DEFAULT_HTTP_STATUS);
    }
}