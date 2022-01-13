package com.example.esportsbackend.handlers.exceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException() {
        super("The team you wanted to find does not exist yet.");
    }
}
