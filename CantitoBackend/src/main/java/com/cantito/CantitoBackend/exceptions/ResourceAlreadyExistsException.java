package com.cantito.CantitoBackend.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(){
        super("User already Exists");
    }

    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}
