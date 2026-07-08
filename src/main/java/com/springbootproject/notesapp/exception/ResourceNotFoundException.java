package com.springbootproject.notesapp.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
