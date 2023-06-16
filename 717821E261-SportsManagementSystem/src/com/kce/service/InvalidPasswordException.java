package com.kce.service;
public class InvalidPasswordException extends Exception {
public String toString() {
	return "please enter a valid Password";
}
}