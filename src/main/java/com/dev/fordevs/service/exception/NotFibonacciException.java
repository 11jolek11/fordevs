package com.dev.fordevs.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFibonacciException extends ResponseStatusException {
    public NotFibonacciException() {
        super(HttpStatus.BAD_REQUEST, "Argument is not from Fibonacci sequence");
    }

    public NotFibonacciException(Throwable cause) {
        super(HttpStatus.BAD_REQUEST, "Argument is not from Fibonacci sequence", cause);
    }
}
