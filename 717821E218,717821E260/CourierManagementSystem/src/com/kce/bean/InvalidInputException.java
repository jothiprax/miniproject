package com.kce.bean;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}