/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.exceptionHandler;

import java.util.HashMap;
import org.springframework.http.HttpStatus;

/**
 *
 * @author iqbal
 */
public class ExceptionResponse {
    private String message;
    private HashMap<String, String> errorList;
    private HttpStatus httpStatus;
    
    public ExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HashMap<String, String> getErrorList() {
        return errorList;
    }

    public void setErrorList(HashMap<String, String> errorList) {
        this.errorList = errorList;
    }
    
    public ExceptionResponse(HashMap<String,String> errorList, HttpStatus httpStatus) {
        this.errorList = errorList;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    
}
