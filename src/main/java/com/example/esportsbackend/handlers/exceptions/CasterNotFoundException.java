package com.example.esportsbackend.handlers.exceptions;

public class CasterNotFoundException extends RuntimeException{
    public CasterNotFoundException() {
        super("The caster you are looking for does not exist");
    }
}
