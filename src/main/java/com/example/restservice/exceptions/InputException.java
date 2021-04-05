package com.example.restservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid params")
public class InputException extends RuntimeException {
    public InputException(String message) {
        super(message);
    }
}
