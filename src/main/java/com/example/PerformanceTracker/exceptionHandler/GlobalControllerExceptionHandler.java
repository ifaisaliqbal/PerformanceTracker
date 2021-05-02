/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.exceptionHandler;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author iqbal
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleUnhandledException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), status);
        return new ResponseEntity(response, status);
    }
    
    @ExceptionHandler(value = {InputNotValidException.class})
    public ResponseEntity<Object> handleInvalidInput(InputNotValidException e, HttpServletResponse res) {
        HashMap<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(item ->{
            errors.put(((FieldError) item).getField(), item.getDefaultMessage());
        });
        ExceptionResponse response = new ExceptionResponse(errors, e.getHttpStatus());
        return new ResponseEntity(response, e.getHttpStatus());
    }
    
    @ExceptionHandler(value = {UserExistsException.class})
    public ResponseEntity<Object> handleUserAlreadyExists(UserExistsException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        ExceptionResponse response = new ExceptionResponse("User already exists", status);
        return new ResponseEntity(response, status);
    }
}
