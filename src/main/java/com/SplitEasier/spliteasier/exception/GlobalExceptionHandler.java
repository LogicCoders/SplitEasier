package com.SplitEasier.spliteasier.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
   private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
   @ExceptionHandler(value = HttpClientErrorException.class)
    public void handleHttpException(HttpClientErrorException exception){
       logger.error("Error: " + "Status Code: " + exception.getStatusCode() + "-" + exception.getMessage());
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public void handleNoSuchElementException(NoSuchElementException exception){
        logger.error("Element not found: {}", exception.getMessage());
    }
    @ExceptionHandler(value = IOException.class)
    public void handleNoSuchElementException(IOException ioException){
        logger.error("File not found: {}", ioException.getMessage());
    }
}
