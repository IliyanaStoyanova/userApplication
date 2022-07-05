package com.iliyana.userapplication.exception;

public class UserGenerateException extends RuntimeException{
    private String message;

    public UserGenerateException(String message) {
        super(message);
        this.message = message;
    }
}
