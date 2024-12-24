package com.cantito.CantitoBackend.exceptions;

import com.cantito.CantitoBackend.entities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public APIResponse handleUserAlreadyExists(UserAlreadyExistsException exception){
        APIResponse response = new APIResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.CONFLICT);
        return response;
    }

    public APIResponse handleResourceNotFound(ResourceNotFoundException exception){
        APIResponse response = new APIResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND);
        return response;
    }
}
