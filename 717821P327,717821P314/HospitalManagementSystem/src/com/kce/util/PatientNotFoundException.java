package com.kce.util;

// Custom exception class for Patient not found
public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
