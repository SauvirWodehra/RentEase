package com.sauvir.RentEase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullObjectException extends RuntimeException {
    public NullObjectException(String message) {
        super(message);
    }
}
