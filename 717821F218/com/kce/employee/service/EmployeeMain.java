package com.kce.employee.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kce.employee.bean.Attendance;
import com.kce.employee.bean.Employee;
import com.kce.employee.bean.Salary;
import com.kce.employee.dao.AttendanceDAO;
import com.kce.employee.dao.EmployeeDAO;
import com.kce.employee.dao.SalaryDAO;

public class EmployeeMain {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			boolean flag  = false;
			while (true) {
				System.out.println("Enter your choice");
				System.out.println("1.Employee\n2.Salary\n3.Attendance\n4.Exit");
				int choice = Integer.parseInt(in.readLine());
				switch (choice) {
				case 1:
					EmployeeDAO empDAO = new EmployeeDAO();
					System.out.println("Enter Your Choice");
					System.out.println(
							"1.Add Employee\n2.Delete Employee\n3.DisplayEmployee\n4.Display All Employee\n5.Update Employee");
					int empChoice = Integer.parseInt(in.readLine());

					switch (empChoice) {
					case 1:
						int id = 0;
						String[] details = new String[4];
						System.out.println("Enter Employee Id");
						id = Integer.parseInt(in.readLine());
						System.out.println("Enter Employee Name");
						details[0] = in.readLine();
						System.out.println("Enter Employee Email");
						details[1] = in.readLine();
						System.out.println("Enter Employee MobileNumber");
						details[2] = in.readLine();
						System.out.println("Enter Employee City");
						details[3] = in.readLine();
						Employee emp = new Employee(id, details[0], details[1], details[2], details[3]);
						empDAO.addEmployee(emp);
						break;
					case 2:
						System.out.println("Enter Employee ID to Delete");
						int deleteId = Integer.parseInt(in.readLine());
						empDAO.deleteEmployee(deleteId);
						break;
					case 3:
						System.out.println("Enter Employee ID to Display");
						int displayID = Integer.parseInt(in.readLine());
						empDAO.displayEmployee(displayID);
						break;
					case 4:
						empDAO.displayAllEmployees();
						break;
					case 5:
						System.out.println("Enter Employee Id to Update");
						int updateId = Integer.parseInt(in.readLine());
						System.out.println("Enter 1 to update ID");
						System.out.println("Enter 2 to update Name");
						System.out.println("Enter 3 to update Email");
						System.out.println("Enter 4 to update MobileNumber");
						System.out.println("Enter 5 to update City");
						int updateChoice = Integer.parseInt(in.readLine());
						System.out.println("Enter the detail to Update");
						Object o = in.readLine();
						empDAO.updateEmployee(updateId, updateChoice, o);
						break;
					default:
						System.out.println("Invalid Choice !!!");
					}
					break;
				case 2:
					SalaryDAO salDAO = new SalaryDAO();
					System.out.println("Enter your Choice");
					System.out.println("1.Add Salary\n2.Display Salary\n3.Update Salary");
					int salChoice = Integer.parseInt(in.readLine());
					switch (salChoice) {
					case 1:
						System.out.println("Enter Employee Id");
						int id = Integer.parseInt(in.readLine());
						System.out.println("Enter Employee Salary");
						double sal = Double.parseDouble(in.readLine());
						System.out.println("Enter Employee Account Number");
						String acc = in.readLine();
						Salary salaryDetails = new Salary(id, sal, acc);
						salDAO.addSalary(salaryDetails);
						break;
					case 2:
						System.out.println("Enter id to display");
						int displayId = Integer.parseInt(in.readLine());
						salDAO.displaySalary(displayId);
						break;
					case 3:
						System.out.println("Enter Employee Id to update salary");
						int updateId = Integer.parseInt(in.readLine());
						System.out.println("Enter Salary to update");
						double updateSalary = Double.parseDouble(in.readLine());
						salDAO.updateSalary(updateSalary, updateId);
						break;
					default:
						System.out.println("Invalid Choice !!!");
					}
					break;
				case 3:
					AttendanceDAO attenDAO = new AttendanceDAO();
					System.out.println("1.Add Attendance\n2.Display Attendance\n3.Update Attendance");
					int attenChoice = Integer.parseInt(in.readLine());
					switch(attenChoice) {
					case 1:
						System.out.println("Enter Employee Id");
						int attenId =Integer.parseInt(in.readLine());
						System.out.println("Enter Attendance percentage of Employee");
						double percent  = Double.parseDouble(in.readLine());
						System.out.println("Enter No Of days Leave Taken");
						int taken = Integer.parseInt(in.readLine());
						System.out.println("Enter No Of days Leave Left");
						int left = Integer.parseInt(in.readLine());
						Attendance atten = new Attendance(attenId,percent,taken,left);
						attenDAO.addAttendance(atten);
						break;
					case 2:
						System.out.println("Enter a Employee Id to Display");
						int displayId = Integer.parseInt(in.readLine());
						attenDAO.displayAttendance(displayId);
						break;
					case 3:
						  System.out.println("Enter Employee Id to Update");
							int updateId = Integer.parseInt(in.readLine());
							System.out.println("Enter Salary to update");
							double updateAtten = Double.parseDouble(in.readLine());
							attenDAO.updateAttendance(updateAtten, updateId);
							break;
					default: System.out.println("Invalid Choice !!!");
					}
				case 4: flag = true; break;
				default: System.out.println("Invalid Choice !!!");
				}
				if(flag) break;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
