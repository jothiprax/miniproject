package com.kce.util;

public class QuantityExceededException extends Exception{
    public QuantityExceededException() {

    }

    public QuantityExceededException(String message) {
        super(message);
    }
}