package com.myblog.myblog11.exception;

import com.myblog.myblog11.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerMethod(ResourceNotFoundException ex, WebRequest webRequest){

      ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(true)) ;

      return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
