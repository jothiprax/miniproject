package com.kce.quiz.util;

public class InvalidChoiceException extends Exception{
 @Override
	public String toString() {
	return "You have Selected wrong option ! select from the above choice a - d";
	}
}
