package com.SplitEasier.spliteasier.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(value = HttpClientErrorException.class)
    public void handleHttpException(HttpClientErrorException exception){
       System.out.println("Error: " + "Status Code: " + exception.getStatusCode() + "-" + exception.getMessage());
    }
}
