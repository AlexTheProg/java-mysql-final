package com.example.esportsbackend.handlers;

public class TeamGameException extends RuntimeException{
    public TeamGameException(String message) {
        super(message);
    }

    public TeamGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
