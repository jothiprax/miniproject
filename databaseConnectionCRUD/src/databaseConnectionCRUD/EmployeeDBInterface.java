package databaseConnectionCRUD;

public interface EmployeeDBInterface 
{
	//Employee employee=new Employee();
	public void createEmployee(Employee employee);
	public void showAllEmployee();
	public void showEmployeeBasedOnId(int id);
	public void UpdateEmployee(int id,String name);
	public void deleteEmployee(int id);
	
}
