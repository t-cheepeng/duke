package com.chee.error;

public class CorruptDataException extends RuntimeException {

    public CorruptDataException(String message) {
        super(message);
    }
}
