package databaseConnectionCRUD;
import java.sql.*;
public class EmployeeDBImplement implements EmployeeDBInterface
{
	Connection con;
		public void createEmployee(Employee employee)
		{
			con=DBConnection.createDBConnection();
			String query="insert into employee values(?,?,?,?)";
			try
			{
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,employee.getId());
			pst.setString(2, employee.getName());
			pst.setDouble(3, employee.getSalary());
			pst.setInt(4, employee.getAge());
			int count=pst.executeUpdate();
			if(count!=0)
			{
				System.out.println("Employee inserted Succesfully !");
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		public void showAllEmployee()
		{
			con=DBConnection.createDBConnection();
			String query="select * from employee";
			System.out.println("Employee Details: ");
			System.out.println("----------------------------------------------------------------------");
			System.out.format("%s\t%s\t\t%s\t\t%s","ID","NAME","SALARY","AGE\n");
			System.out.println("----------------------------------------------------------------------");
			try
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					System.out.format("%d\t%s\t\t%f\t%d",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
					System.out.println("\n----------------------------------------------------------------------");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		public void showEmployeeBasedOnId(int id)
		{
			con=DBConnection.createDBConnection();
			String query="select * from employee where id="+id;
			try
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				System.out.println("----------------------------------------------------------------------");
				System.out.format("%s\t%s\t\t%s\t\t%s","ID","NAME","SALARY","AGE\n");
				System.out.println("----------------------------------------------------------------------");
				while(rs.next())
				{
					System.out.format("%d\t%s\t\t%f\t%d",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
					System.out.println("\n----------------------------------------------------------------------");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		public void UpdateEmployee(int id,String name)
		{
			con=DBConnection.createDBConnection();
			String query="update employee set name=? where id=?";
			try
			{
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, name);
				pst.setInt(2, id);
				int c=pst.executeUpdate();
				if(c!=0)
				{
					System.out.println("Employee details updated succesfully !");
				}
			}
			catch(Exception e)
			{
			    e.printStackTrace();
			}
		}
		public void deleteEmployee(int id)
		{
			con=DBConnection.createDBConnection();
			String query="delete from employee where id=?";
			try
			{
				PreparedStatement pst=con.prepareStatement(query);
				pst.setInt(1, id);
				int cnt=pst.executeUpdate();
				if(cnt!=0)
				{
					System.out.println("Employee deleted succesfully !");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
}
