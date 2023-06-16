package com.kce.customer;
public class customer 
{
	static String username;
	static String password;
	static String name;
	static int age;
	static  Long mobile_no;
	static String address;
	public customer(String username,String password,String name,int age,Long mobile_no,String address)
	{
		   this.username=username;
		   this.password=password;
		   this.name=name;
		   this.age=age;
		   this.mobile_no=mobile_no;
		   this.address=address;
	}
	public static String getName() 
	{
		return name;
	}
	public static int getAge() 
	{
		return age;
	}
	public static Long getMobile_no() 
	{
		return mobile_no;
	}
	public static String getAddress() 
	{
		return address;
	}
	public static String getPassword() {
		return password;
	}
	public static String getUsername() {
		return username;
		}
}