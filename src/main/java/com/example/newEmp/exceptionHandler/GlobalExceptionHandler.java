package com.example.newEmp.exceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Map<Object, String> validationExceptions(ConstraintViolationException e) {
        Map<Object, String> mp = new HashMap<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            System.out.println(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            mp.put(constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
        return mp;
    }

}
