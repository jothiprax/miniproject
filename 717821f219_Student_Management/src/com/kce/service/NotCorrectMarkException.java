package com.kce.service;
import java.util.*;

public class NotCorrectMarkException extends Exception {
        public NotCorrectMarkException(String str)
        {
        	super(str);
        	System.out.println("Enter number between 1-100");
        }
}
