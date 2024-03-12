import java.lang.*;

public class Bank implements CustomerOperations, EmployeeOperations
{
	private Customer customers[] = new Customer [500];
	private Employee employees[] = new Employee [100];
	
	public void insertCustomer(Customer c)
	{
		int count = 0;
		for(int i=0; i<customers.length; i++)
		{
			if(customers[i] == null)
			{
				customers[i] = c;
				count = 1;
				break;
			}
		}
		if(count == 1)
		{
			System.out.println("Customer Inserted");
		}
		else
		{
			System.out.println("Can Not Insert");
		}
	}
	
	public void removeCustomer(Customer c)
	{
		int count = 0;
		for(int i=0; i<customers.length; i++)
		{
			if(customers[i] == c)
			{
				customers[i] = null;
				count = 1;
				break;
			}
		}
		if(count == 1)
		{
			System.out.println("Customer Removed");
		}
		else
		{
			System.out.println("Can Not Remove");
		}
	}
	public void showAllCustomers()
	{
		for(Customer c : customers)
		{
			if(c != null)
			{
				System.out.println("==================================");
				System.out.println("Customer Name: "+ c.getName());
				System.out.println("Customer NID: "+ c.getNid());
				System.out.println("----------------------------------");
				c.showAllAccounts();
				System.out.println("==================================");
			}
		}
	}
	public Customer getCustomer(int nid)
	{
		Customer c = null;
		
		for(int i=0; i<customers.length; i++)
		{
			if(customers[i] != null)
			{
				if(customers[i].getNid() == nid)
				{
					c = customers[i];
					break;
				}
			}
		}
		if(c != null)
		{
			System.out.println("Customer Found");
		}
		else
		{
			System.out.println("Customer Not Found");
		}
		return c;
	}
	
	
	public void insertEmployee(Employee e)
	{
		int count = 0;
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i] == null)
			{
				employees[i] = e;
				count = 1;
				break;
			}
		}
		if(count == 1)
		{
			System.out.println("Employee Inserted");
		}
		else
		{
			System.out.println("Can Not Insert");
		}
	}
	
	public void removeEmployee(Employee e)
	{
		int count = 0;
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i] == e)
			{
				employees[i] = null;
				count = 1;
				break;
			}
		}
		if(count == 1){System.out.println("Employee Removed");}
		else{System.out.println("Can Not Remove");}
	}
	public void showAllEmployees()
	{
		System.out.println("===============================");
		for(Employee e : employees)
		{
			if(e != null)
			{
				System.out.println("Employee Name: "+ e.getName());
				System.out.println("Employee ID: "+ e.getEmpId());
				System.out.println("Salary: "+ e.getSalary());
				System.out.println();
			}
		}
		System.out.println("==============================");
	}
	public Employee getEmployee(String empId)
	{
		Employee e = null;
		
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i] != null)
			{
				if(employees[i].getEmpId().equals(empId))
				{
					e = employees[i];
					break;
				}
			}
		}
		if(e != null)
		{
			System.out.println("Employee Found");
		}
		else
		{
			System.out.println("Employee Not Found");
		}
		return e;
	}
}