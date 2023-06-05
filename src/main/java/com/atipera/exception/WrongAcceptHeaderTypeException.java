package com.atipera.exception;

import org.springframework.http.HttpStatus;

public class WrongAcceptHeaderTypeException extends GithubException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.NOT_ACCEPTABLE;

    public WrongAcceptHeaderTypeException(String mediaType) {
        super(String.format("You cannot use application/xml header.", mediaType), DEFAULT_HTTP_STATUS);
    }
}