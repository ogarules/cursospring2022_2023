package com.example.demo.ejercicio31;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice(assignableTypes={PersonRestController.class})
public class ErrorHandlingAdvice {
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponseError onException(IllegalArgumentException e){
        return new RestResponseError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getClass().getSimpleName());
    }
}
