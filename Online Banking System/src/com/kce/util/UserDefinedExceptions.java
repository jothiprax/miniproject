package com.kce.util;

@SuppressWarnings("serial")
public class UserDefinedExceptions extends Exception{
    String Exception;
    public UserDefinedExceptions(String a){
    	Exception=a;
    }public String toString() {
    	return Exception;
    }
}
