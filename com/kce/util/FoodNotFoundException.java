package com.kce.util;

public class FoodNotFoundException extends Exception{
	
	public String toString()
	{
		return "Food Not Found In Your Order";
	}
}
