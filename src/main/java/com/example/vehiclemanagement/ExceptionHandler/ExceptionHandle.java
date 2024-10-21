package com.example.vehiclemanagement.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  Map<String, String > handle(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        for (FieldError error: e.getBindingResult().getFieldErrors()){
            String fieldname = error.getField() + " ";
            String errorMessage = error.getDefaultMessage() + " ";
            errors.put(fieldname, errorMessage);
        }
        return errors;
    }
}
