package com.taskmanagement;

public class TaskAllocator extends Person {
	
	//To store the Details of TaskAllocator into Variables Through Constructor.
	public TaskAllocator(String taskAllocatorId, String taskAllocatorFirstName, String taskAllocatorName) {
		
		//Assign the Local Variables Values to Global Variable Values.
		super.id = taskAllocatorId;
		super.firstName = taskAllocatorFirstName;
		super.lastName = taskAllocatorName;
				
	}
}
