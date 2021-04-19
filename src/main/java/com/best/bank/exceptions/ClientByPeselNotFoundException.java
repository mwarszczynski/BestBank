package com.best.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientByPeselNotFoundException extends RuntimeException {
    public ClientByPeselNotFoundException(String exception) {
        super(exception);
    }
}
