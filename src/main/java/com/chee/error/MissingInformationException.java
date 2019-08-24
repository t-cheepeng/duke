package com.chee.error;

public class MissingInformationException extends RuntimeException {

    public MissingInformationException(String message) {
        super(message);
    }
}
