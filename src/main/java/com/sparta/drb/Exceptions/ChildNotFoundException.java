package com.sparta.drb.Exceptions;

public class ChildNotFoundException extends Exception {
    String message;

    public ChildNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
