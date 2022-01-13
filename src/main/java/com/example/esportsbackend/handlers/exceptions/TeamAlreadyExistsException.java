package com.example.esportsbackend.handlers.exceptions;

public class TeamAlreadyExistsException extends RuntimeException{
    public TeamAlreadyExistsException() {
        super("There is already a team registered with the same name");
    }
}
