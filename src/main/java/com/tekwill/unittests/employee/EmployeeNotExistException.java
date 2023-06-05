package com.tekwill.unittests.employee;

public class EmployeeNotExistException extends RuntimeException {

    public EmployeeNotExistException(String message) {
        super(message);
    }
}
