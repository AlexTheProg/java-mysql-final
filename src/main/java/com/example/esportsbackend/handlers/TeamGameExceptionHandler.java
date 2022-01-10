package com.example.esportsbackend.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class TeamGameExceptionHandler {

    @ExceptionHandler(value = {TeamGameException.class})
    public ResponseEntity<Object> handle(TeamGameException e){
        TeamGameExceptionModel teamGameException = new TeamGameExceptionModel(
                e.getMessage(),
                e,
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(teamGameException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
