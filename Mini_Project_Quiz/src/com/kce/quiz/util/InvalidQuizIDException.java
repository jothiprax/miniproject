package com.kce.quiz.util;
public class InvalidQuizIDException extends Exception{
       public String toString() {
    	   return "You have selected the wrong Quiz Id \n!!! Please select from the above list !!!";
       }
}
