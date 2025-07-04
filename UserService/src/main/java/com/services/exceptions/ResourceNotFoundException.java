package com.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource Not found on Server");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
