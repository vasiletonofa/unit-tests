package com.tekwill.unittests.employee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class,})
    public ResponseEntity<Object> handleError(RuntimeException e, WebRequest webRequest) {
        String message = "One or many parameters are null or empty !!";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalState(RuntimeException e, WebRequest webRequest) {
        String message = "illegal state handled";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {EmployeeNotExistException.class,})
    public ResponseEntity<Object> handleEmployeeNotExistException(RuntimeException e, WebRequest webRequest) {
        String message = "Nu exista asa angajat !!";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }
}
