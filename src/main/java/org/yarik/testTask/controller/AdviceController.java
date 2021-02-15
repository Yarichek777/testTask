package org.yarik.testTask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.yarik.testTask.jwt.JwtAuthenticationException;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException() {
        return new ResponseEntity<String>("Not found element!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpClientErrorException.Forbidden.class)
    public ResponseEntity<String> forbidden() {
        return new ResponseEntity<>("Insufficient permissions to execute this request! Go to the login page", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException() {
        return new ResponseEntity<>("Not valid data in the request!", HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = JwtAuthenticationException.class)
    public ResponseEntity<String> jwtAuthenticationException(){
        return new ResponseEntity<>("JWT token is expired or invalid!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException() {
        return new ResponseEntity<>("Incorrect value in the request!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> badRequest() {
        return new ResponseEntity<>("Bad request, incorrect syntax in the request!", HttpStatus.BAD_REQUEST);
    }

}