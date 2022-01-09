package com.example.esportsbackend.handlers;

public class TeamNotFoundException extends Exception{
    public TeamNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
