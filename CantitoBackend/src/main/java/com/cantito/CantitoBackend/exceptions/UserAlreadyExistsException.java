package com.cantito.CantitoBackend.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super("User already Exists");
    }

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
