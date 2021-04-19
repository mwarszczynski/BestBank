package com.best.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClientByPeselAlreadyExistException extends RuntimeException {
    public ClientByPeselAlreadyExistException(String exception) {
        super(exception);
    }
}
