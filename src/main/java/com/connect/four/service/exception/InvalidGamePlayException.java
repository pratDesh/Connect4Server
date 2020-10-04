package com.connect.four.service.exception;

public class InvalidGamePlayException extends RuntimeException {
    private String message;

    public InvalidGamePlayException(String message) {
        super(message);
    }
}
