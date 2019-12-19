package com.publicissapient.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CardDuplicationException.class)
    protected ResponseEntity<Object> handleConflict()
    {
        return new ResponseEntity<>("Card is already present.",HttpStatus.CONFLICT);
    }
}
