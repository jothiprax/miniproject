package com.taskmanagement;

import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class MainClass {

	public static void main(String[] args) throws Exception {
		//project name.
		System.out.println("					Task Management System");
		//URL, Admin and Password for Connecting DataBase.
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String admin = "system";
		String password = "devasenan";
		
		//To Establish the Connection.
		Class classObject = Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, admin, password);
		Statement statementObject = connection.createStatement();
		
		//To Create EmployeTable, TaskAllocationTable, TaskCompletionStatusTable, UploadingFilesTable, UploadedFilesTable
		statementObject.executeUpdate("create table EmployeeDetails(empId varchar(255), empFirstName varchar(255), empLastName varchar(255), employeeEmailId varchar(255), empJoinedDate varchar(255), empSalary varchar(255), status varchar(255))");
		statementObject.executeUpdate("create table TaskAllocationTable(empId varchar(255), task varchar(255), deadLine date)");
		statementObject.executeUpdate("create table TaskCompletionStatusTable(empId varchar(255), status varchar(255))");
		statementObject.executeUpdate("create table UploadFilesTable(empId varchar(255), files blob)");
		
		//Variable for Storing the User input for menu Selection.
		String menuSelection = null;
		
		//Create the Reader Object for reading the Input.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//Creating Object for Main Class.
		MainClass main = new MainClass();
		
		//To Get TaskAllocator Details.
		System.out.println("Please Enter Your Details (As a TaskAllocator)\n");
		System.out.print("Id: ");
		String id = input.readLine();
		System.out.print("First Name: ");
		String firstName = input.readLine();
		System.out.print("Last Name: ");
		String lastName = input.readLine();
		
		Person taskAllocatorObject = new TaskAllocator(id, firstName, lastName);
		
		//Welcome Message.
		System.out.printf("%-60s%-15s\n\n\n","", "Welcome "+taskAllocatorObject.firstName);
		
		//To Show the MenuBar.
		showMenuBar();
		
		//Show the Text Message to the User.
		System.out.println("How Can I Help You? ");
		
		//Get the Desired Menu as the Input from the User.
		menuSelection = input.readLine();
		
		//Perform the Complete Operation in this operation() Function.
		main.operation(menuSelection, connection, input);
		
		//Drop the Created Table for Again creating this table with same Name.
		/*statementObject.executeUpdate("drop table EmployeeDetails");
		statementObject.executeUpdate("drop table TaskAllocationTable");
		statementObject.executeUpdate("drop table TaskCompletionStatusTable");
		statementObject.executeUpdate("drop table UploadFilesTable");*/
		
	}
	
	//This showMenuBar() Function Will Show the MenuBar.
	public static void showMenuBar() {
		System.out.printf("%-3s%-8s%-3s%-8s%-8s%-8s%-8s%-10s%-7s%-10s%-7s%-10s%-7s%-20s\n\n", "", "Entry", "", "TaskAllocation", "", "TaskCompletionStatus", "",  "UploadFiles", "", "ShowEmployeeDetails", "", "exitMenu", "", "exit");
	}
	
	//To Perform the Complete Operation in this operation() Function.
	public void operation(String menuSelection, Connection connection, BufferedReader input) throws Exception {
		
		//This variable for Execute the loop Until the employeeLimit.
		int employeeLimit;
		
		//This variable for Store the employeeLimit as Temporary;
		int temporaryEmployeeLimit = 0;
		
		switch(menuSelection.toLowerCase()) {
		case "entry" : {
			//Get the Employee Limit
			System.out.println("Plese Enter the Employee Limit");
			employeeLimit = Integer.parseInt(input.readLine());
			temporaryEmployeeLimit = employeeLimit;
			System.out.println("\nNow You should Enter the Employee Details In the Given Order\n");
			System.out.println("Id	FirstName	LastName	EmailId    JoinedDate(YYYY-MM-DD)	Salary");
			while(temporaryEmployeeLimit != 0) {
				//To Create the Object for Prepared Statement.
				PreparedStatement preparedstatementObject = connection.prepareStatement("Insert Into EmployeeDetails values(?, ?, ?, ?, ?, ?, ?)");
				preparedstatementObject.setString(1, input.readLine());
				preparedstatementObject.setString(2, input.readLine());
				preparedstatementObject.setString(3, input.readLine());
				preparedstatementObject.setString(4, input.readLine());
				preparedstatementObject.setString(5, input.readLine());
				preparedstatementObject.setString(6, input.readLine());
				preparedstatementObject.setString(7,  "Not Uploaded");
				preparedstatementObject.executeUpdate();
				preparedstatementObject.close();
			
				temporaryEmployeeLimit--;
			}
			break;
		}
		case "taskallocation" : {
			//Get the Employee Limit
			System.out.println("\nPlese Enter the Employee Limit");
			employeeLimit = Integer.parseInt(input.readLine());
			//Format.
			System.out.println("\nFormat:		EmployeeId		Task		DeadLine(YYYY-MM-DD)\n");
			temporaryEmployeeLimit = employeeLimit;
			while(temporaryEmployeeLimit != 0) {
				//To Create the Object for Prepared Statement.
				PreparedStatement preparedstatementObject = connection.prepareStatement("Insert Into TaskAllocationTable values(?, ?, ?)");
				preparedstatementObject.setString(1, input.readLine());
				preparedstatementObject.setString(2, input.readLine());
				
				//Get the Date From user and Modify by using LocalDate and Date Classes.
				Date dateObject = Date.valueOf(input.readLine());
				preparedstatementObject.setDate(3, dateObject);
				
				preparedstatementObject.executeUpdate();
				temporaryEmployeeLimit--;
			}
			break;
		}
		case "taskcompletionstatus": {
			System.out.println("									Task Completion Status");
			
			//Getting All Employee Details whether the employee was done their work or not.
			System.out.printf("%-25s%-25s%-25s%-35s\n", "Id", "FirstName",	"EmailId", "TaskStatus");
			Statement statementObject = connection.createStatement();
			ResultSet resultSetObject = statementObject.executeQuery("select empId, empFirstName, employeeEmailId, status from EmployeeDetails");
			while(resultSetObject.next()) {
				System.out.printf("%-25s%-25s%-25s%-35s\n", resultSetObject.getString(1), resultSetObject.getString(2), resultSetObject.getString(3), resultSetObject.getString(4));
			}
			break;
		}
		case "uploadfiles" : {
			//Get the Employee Limit
			System.out.println("\nPlese Enter the Employee Limit");
			employeeLimit = Integer.parseInt(input.readLine());
			temporaryEmployeeLimit = employeeLimit;
			System.out.println("\nFormat: 	EmployeeId		FileName\n");
			while(temporaryEmployeeLimit != 0) {
				
				//This PrepareStatement for File Upload.
				PreparedStatement preparedstatementFileUploadObject = connection.prepareStatement("Insert Into UploadFilesTable values(?, ?)");
				
				//This PrepareStatement for File Status.
				//PreparedStatement preparedstatementTaskStatusObject = connection.prepareStatement("Insert Into TaskCompletionStatusTable values(?, ?)");
				
				//Getting Employee Id
				String upload = "Uploaded";
				String empId = input.readLine();
				
				//Setting Employee Id
				preparedstatementFileUploadObject.setString(1, empId);
				//preparedstatementTaskStatusObject.setString(1, empId);
				
				//Get the File from User.
				Path filePath = Paths.get(input.readLine());
				
				//Convert the File into Bytes.
				byte[] fileData = Files.readAllBytes(filePath);
				
				//Setting File.
				preparedstatementFileUploadObject.setBytes(2, fileData);
				
				//Setting status.
				//preparedstatementFileUploadObject.setString(3, upload);
				preparedstatementFileUploadObject.executeUpdate();
				
				preparedstatementFileUploadObject = connection.prepareStatement("update EmployeeDetails set status = ? where empId = ?");
				preparedstatementFileUploadObject.setString(1, upload);
				preparedstatementFileUploadObject.setString(2, empId);
				//Setting Status.
				//preparedstatementTaskStatusObject.setString(2, upload);
				
				preparedstatementFileUploadObject.executeUpdate();
				
				temporaryEmployeeLimit--;
			}
			break;
		}
		case "showemployeedetails" : {
			
			Statement statementObject = connection.createStatement();
			
			System.out.println("Choices:	1.EmployeePersonalDetails		2.EmployeeTaskDetails");
			String choice = input.readLine();
			
			if(choice.equalsIgnoreCase("EmployeePersonalDetails".toLowerCase())) {
				System.out.printf("%-40s%-15s\n\n","","Employee's Personal Details");
				ResultSet resultSetObject = statementObject.executeQuery("select * from EmployeeDetails");
				System.out.printf("%-25s%-25s%-25s%-35s%-25s\n", "Id", "FirstName",	"LastName",	"EmailId", "JoinedDate", "Salary");
				while(resultSetObject.next()) {
					System.out.printf("%-25s%-25s%-25s%-35s%-25s\n", resultSetObject.getString(1), resultSetObject.getString(2), resultSetObject.getString(3), resultSetObject.getString(4), resultSetObject.getString(5), resultSetObject.getString(6));
				}
			}
			if(choice.equalsIgnoreCase("EmployeeTaskDetails".toLowerCase())) {
				ResultSet resultSetObject = statementObject.executeQuery("select EmployeeDetails.empId, EmployeeDetails.empFirstName, EmployeeDetails.employeeEmailId, TaskAllocationTable.task, TaskAllocationTable.deadLine from EmployeeDetails inner join TaskAllocationTable on EmployeeDetails.empId = TaskAllocationTable.empId");
				System.out.printf("%-50s%-15s\n\n","","Employee's Task Details");
				System.out.printf("%-25s%-25s%-25s%-35s%-25s\n", "Id", "FirstName",	"EmailId", "Task", "DeadLine");
				while(resultSetObject.next()) {
					System.out.printf("%-25s%-25s%-25s%-35s%-25s\n", resultSetObject.getString(1), resultSetObject.getString(2), resultSetObject.getString(3), resultSetObject.getString(4), resultSetObject.getString(5));
					//System.out.println();
				}
			}
			System.out.println("\n");
			break;
		}
		case "exit": {
			System.out.printf("%-60s%-15s", "", "Thank You!");
			System.exit(0);
			break;
		}
		default:{
			System.out.println("Your Choice is Invalid! Better Luck Next Time");
		}	
		}
		
		//If user enter exit-menu then Again User Should Enter the Choice.
		//If user enter exit then Completely User will exit from the Application.
		
		if(temporaryEmployeeLimit == 0) {
			System.out.println("If you want to Exit From this Menu then Enter exit-menu (or) If you want to Exit From this Application Enter exit");
			String userChoice = input.readLine();
			if(userChoice.equalsIgnoreCase("exit-menu")) {
				showMenuBar();
				System.out.println("Enter the Next Menu");
				menuSelection = input.readLine();
				operation(menuSelection, connection, input);
			}
			else if(userChoice.equalsIgnoreCase("exit")) {
				System.out.printf("%-60s%-15s", "", "Thank You!");
			}
			else {
				System.out.println("Enter the Right Choice Please...");
				showMenuBar();
				System.out.println("Enter the Next Menu");
				menuSelection = input.readLine();
				operation(menuSelection, connection, input);
			}
		}
	}
	

}