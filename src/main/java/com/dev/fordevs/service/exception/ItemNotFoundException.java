package com.dev.fordevs.service.exception;

import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends ResponseStatusException {
    public ItemNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public ItemNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }
}
