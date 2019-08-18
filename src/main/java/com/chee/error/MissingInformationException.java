package com.chee.error;

public class MissingInformationException extends RuntimeException {

    public MissingInformationException() {}

    public MissingInformationException(String message) {
        super(message);
    }
}
