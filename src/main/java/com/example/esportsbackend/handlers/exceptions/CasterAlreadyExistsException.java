package com.example.esportsbackend.handlers.exceptions;

public class CasterAlreadyExistsException extends RuntimeException{
    public CasterAlreadyExistsException() {
        super("The caster you are trying to add is already signed up");
    }
}
