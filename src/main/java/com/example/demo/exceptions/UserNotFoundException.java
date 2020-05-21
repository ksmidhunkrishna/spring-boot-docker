package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name) {
        super(String.format("username %s not found . ", name));
    }
}
