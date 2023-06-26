package shopManagement;

import java.sql.*;

public class Add_Stock
{
	int pid; 
	String pname; 
	double price;
	int quantity;
  
	public Add_Stock (int pid, String pname, double price, int quantity)
		{
			super ();
			this.pid = pid;
			this.pname = pname;
			this.price = price;
			this.quantity = quantity;
		} 
	
	public Add_Stock() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addMedicine() throws SQLException 
	{
		try
		{
			Class.forName ("com.mysql.cj.jdbc.Driver");   
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace (); 
		}
		String query ="insert into Available_stocks values(" + pid + ",'" + pname + "'," +price + "," + quantity + ")";
		Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject","root", "Manick@14"); 
		Statement st = con.createStatement ();   
		st.execute (query);
		System.out.println ("---------------Medicine is added succesfully---------------");
	}
	public void addQuantity(int qty,String name) throws SQLException {
        String query="select Quantity from Available_stocks where product_name='"+name+"'";
        Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject","root", "Manick@14"); 
		Statement st = con.createStatement ();
		ResultSet rs=st.executeQuery (query);
		while(rs.next())
	    qty+=rs.getInt(1);
		query ="update Available_stocks set Quantity="+qty+" where product_name='"+name+"';";
		st.executeUpdate(query);
		System.out.println ("---------------Stock is added succesfully---------------");
	}
} 
