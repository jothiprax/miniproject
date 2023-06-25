package com.kce.service;

import java.util.Scanner;

import com.kce.dao.EmployeeDAO;



public class Main {
public static void main(String[] args)
{
	EmployeeDAO emp=new EmployeeDAO();
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	emp.insert(a);
	emp.displayTable();
	emp.update();
	
	
}
}
