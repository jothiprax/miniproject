import java.lang.*;

public class Employee
{
	private String empId;
	private String name;
	private double salary;
	
	public void setEmpId(String empId){this.empId = empId;}
	public void setName(String name){this.name = name;}
	public void setSalary(double salary){this.salary = salary;}
	
	public String getEmpId(){return empId;} 
	public String getName(){return name;}
	public double getSalary(){return salary;} 
}