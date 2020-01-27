package com.example.springsecurityjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(final String message, Throwable throwable) {
        super(message, throwable);
    }
}
