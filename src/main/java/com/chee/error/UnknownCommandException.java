package com.chee.error;

public class UnknownCommandException extends RuntimeException {
    
    public UnknownCommandException(String message) {
        super(message);
    }
}
