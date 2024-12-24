package com.cantito.CantitoBackend.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not found");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}