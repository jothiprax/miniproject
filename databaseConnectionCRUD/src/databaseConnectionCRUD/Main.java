package databaseConnectionCRUD;
import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		    EmployeeDBImplement edi=new EmployeeDBImplement();
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION\n");
			Scanner sc=new Scanner(System.in);
			do
			{
				System.out.println("1. Add Employee\n2. Show All Employees\n3. Show Employee Based On ID\n4. Update the Employee\n5. Delete the Employee");
				System.out.println("Enter choice: ");
				int ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					Employee employee=new Employee();
					System.out.println("Enter ID: ");
					int id=sc.nextInt();
					System.out.println("Enter Name: ");
					String name=sc.next();
					System.out.println("Enter Salary: ");
					double salary=sc.nextDouble();
					System.out.println("Enter Age: ");
					int age=sc.nextInt();
					employee.setId(id);
					employee.setName(name);
					employee.setSalary(salary);
					employee.setAge(age);
					edi.createEmployee(employee);
					break;
				case 2:
					edi.showAllEmployee();
					break;
				case 3:
					System.out.println("Enter id to show the details :");
					int empid=sc.nextInt();
					edi.showEmployeeBasedOnId(empid);
					break;
				case 4:
					System.out.println("Enter id to update the details:");
					int eid=sc.nextInt();
					System.out.println("Enter the new name: ");
					String ename=sc.next();
					edi.UpdateEmployee(eid,ename);
					break;
				case 5:
					System.out.println("Enter id to delete :");
					int emppid=sc.nextInt();
					edi.deleteEmployee(emppid);
					break;
				case 6:
					System.out.println("Thank you for using our Application !");
					System.exit(0);
				default:
					System.out.println("Enter valid choice");
					break;
				}
			}
			while(true);
	}

}
