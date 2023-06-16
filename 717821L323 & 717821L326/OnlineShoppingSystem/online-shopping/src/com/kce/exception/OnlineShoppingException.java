package com.kce.exception;

public class OnlineShoppingException extends Exception {

    private final String message;

    public OnlineShoppingException(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
