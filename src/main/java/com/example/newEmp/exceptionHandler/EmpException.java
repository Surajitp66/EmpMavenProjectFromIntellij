package com.example.newEmp.exceptionHandler;

public class EmpException extends RuntimeException {
    public EmpException() {
        super();
    }

    public EmpException(String message) {
        super(message);
    }
}
