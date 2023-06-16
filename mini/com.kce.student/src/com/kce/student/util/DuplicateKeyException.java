package com.kce.student.util;

public class DuplicateKeyException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateKeyException() {
		System.out.println("Id already exixt");
	}
}
