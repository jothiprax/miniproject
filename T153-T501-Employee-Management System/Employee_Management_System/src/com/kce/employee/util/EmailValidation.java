package com.kce.employee.util;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidation{
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);


    public static boolean validateEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    } 
}