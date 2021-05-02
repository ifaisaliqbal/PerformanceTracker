/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

/**
 *
 * @author iqbal
 */
public class InputNotValidException extends RuntimeException{

    private HttpStatus httpStatus;
    private BindingResult bindingResult;
    public InputNotValidException(HttpStatus httpStatus, BindingResult bindingResult) {
        this.httpStatus = httpStatus;
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
}
