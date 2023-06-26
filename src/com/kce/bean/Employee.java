package com.kce.bean;

import com.taskmanagement.MainClass;
import com.taskmanagement.Person;

public class Employee extends Person {
	
	//It is a MainClass Variable for Access the Connection
	MainClass MainObject;
	
	//To store the Details of Employees into Variables Through Constructor.
	Employee(String employeeId, String employeeFirstName, String employeeLastName, String joiningDate, double salary) {
		
		//Assign the Local Variables Values to Global Variable Values.
		super.id = employeeId;
		super.firstName = employeeFirstName;
		super.lastName = employeeLastName;
		super.joiningDate = joiningDate;
		super.salary = salary;
	}
	
	//To Set the Object of MainClass.
	public void setMain(MainClass MainObject) {
		this.MainObject = MainObject;
	}
	
	
	
}
