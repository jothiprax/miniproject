package com.kce.restaurant.util;

@SuppressWarnings("serial")
public class OutOfStockException extends Exception
{
 public OutOfStockException(String str) {
	 super(str);
 }
}
