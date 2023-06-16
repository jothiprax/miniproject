package com.kce.DAO;

import com.kce.bean.*;
import com.kce.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class AdminDAO{
	Battery battery =new Battery();
	CustomerBill cb=new CustomerBill();
	User u=new User();
	Scanner sc=new Scanner(System.in);
	public void main_menu() throws Exception{                                                       // displays the main menu with three options: Admin Mode, User Mode, or Exit.
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~MAIN MENU~~~~~~~~~~~~~~~~~~~~~~~~~\n1. Admin Mode\n2. User Mode\n3. Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1: admin_log();
				break;
			case 2: u_user_login();
				break;
			default:System.out.println("");
				   System.exit(0);
				break;
		}
	}
	
	//THIS METHOD IS TO LOGIN WITH PASSWORD
	
	public void admin_log() throws Exception 
	{
		System.out.print("Enter password : ");
		String ps=sc.next();
		if(ps.equals("SuryaMK1234"))
		{
			admin_mode();
		}
		else
		{
			System.out.println("Wrong password contact to the admin!!!!!!");
			main_menu();
		}
	}
	
	//THIS METHOD IS USED TO ACTIVATE AS ADMIN AND IT INCLUDES FUNCTION AS ADD BATTERY,DISPLAY BATERY DETAILS,GENERATING BILLS,ETC..
	
	public void admin_mode() throws Exception{                                     
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ADMINISTRATOR MENU~~~~~~~~~~~~~~~~~~~~~~~~~\n1. Add Battery\n2. Display Battery DataBase\n3. Restock Battery\n4. Generate bill for customer\n5. Return to main menu \n6. Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1: add_battery();
				break;
			case 2: disp_battery_database();
				break;
			case 3:
				System.out.println("Enter the Battery id to be Restock: ");
				String id=sc.next();
				restock_Batteries(id);
				break;
			case 4:
				System.out.println("Enter the Bill Number to be generate bill: ");
				int billno=sc.nextInt();
				generate_bill(billno);
				System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
				String c=sc.next();
				if(c.equals("y"))
				{
					admin_mode();
				}
				else
				{
					main_menu();
				}

				break;
			case 5: main_menu();
				break;
			case 6:
				System.exit(0);
				break;
			default:System.out.println("");
				System.exit(0);
				break;
		}
	}
	
	//THIS METHOD IS USED TO LOGIN AS USER
	
	public void u_user_login() throws Exception
	{
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~WELCOME TO USER MENU~~~~~~~~~~~~~~~~~~~~~~~~~\n1. Login\n2. Sign Up\n3. Return to main menu\n4. Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:user_mode();
				break;
			case 2:user_Signup();;
				break;
			case 3:main_menu();
				break;
			case 4:
				System.exit(0);
				break;
			default:System.out.println("");
					System.exit(0);
				break;
		}
	}
	
	//THIS METHOD WILL GIVE OPTIONS TO THE USER TO SELECT VARIOUS METHODS
	
	public void user_mode() throws Exception                            
	{
		if(user_Login()==1)
		{
			System.out.println("1. To view Battery list\n2. Purchase Battery\n3. Return to main menu\n4. Exit");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1: disp_batterylist_database();
					break;
				case 2: purchasing_battery();
				System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
				String c=sc.next();
				if(c.equals("y"))
				{
					user_mode();
				}
				else
				{
					main_menu();
				}
					break;
				case 3: main_menu();
					break;
				case 4: System.exit(0);
					break;
				default:System.out.println("");
					 System.exit(0);
					break;
			}
		}
		else
		{
			System.out.println("Wrong username or password!!!!!!");
			u_user_login();

		}
	}
	
	//THIS METHOD IS TO ADD BATTERY TO THE TABLE
	
	public void add_battery() throws Exception {                           
		System.out.println("Enter Battery_Id: ");
		String id=sc.next();
		sc.nextLine();
		System.out.println("Enter the Car brand: ");
		String brand=sc.nextLine();
		System.out.println("Enter the Model: ");
		String model=sc.nextLine();
		System.out.println("Enter Warranty of the battery: ");
		int warranty=sc.nextInt();
		System.out.println("Enter Ampere of battery: ");
		int amps=sc.nextInt();
		System.out.println("Enter the Quantity of battery: ");
		int quantity=sc.nextInt();
		System.out.println("Enter the Price of battery: ");
		int price=sc.nextInt();
		battery_db(id,brand,model,warranty,amps,quantity,price);
	}
	
	//THIS METHOD IS USED TO DISPLAY THE BATTERY DATABASE
	
	public void battery_db(String battery_id, String brand, String model, int warranty, int amps,int quantity, int price) throws Exception {
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		st.execute("create table if not exists battery (battery_id varchar(20) NOT NULL ,brand varchar(20) NOT NULL ,model varchar(20) NOT NULL,warranty int NOT NULL,amps int NOT NULL,quantity int NOT NULL,price int NOT NULL)");
		battery=new Battery(battery_id,brand,model,warranty,amps,quantity,price);
		PreparedStatement pst=con.prepareStatement("insert into battery values(?,?,?,?,?,?,?)");
		pst.setString(1, battery.getBattery_id());
		pst.setString(2, battery.getBrand());
		pst.setString(3, battery.getModel());
		pst.setInt(4, battery.getWarranty());
		pst.setInt(5, battery.getAmps());
		pst.setInt(6, battery.getQuantity());
		pst.setInt(7, battery.getPrice());
		pst.executeUpdate();
		System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
		String ch=sc.next();
		if(ch.equals("y"))
		{
			admin_mode();
		}
		else
		{
			main_menu();
		}
	}
	
	//THIS METHOD IS USED TO DISPLAY THE BATTERY DATABASE
	
	public void disp_battery_database() throws Exception {                          
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		try {
		ResultSet rs=st.executeQuery("select * from battery");
		System.out.println("Battery Database:\n");
		StringBuilder batterybuilder=new StringBuilder();
		batterybuilder.append("******************************************************************************************************************************************************************").append("\n");
		batterybuilder.append(String.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n","Battery_id","Car Brand","Model","Warranty","Amps","Quantity","Price"));
		batterybuilder.append("******************************************************************************************************************************************************************").append("\n");
		while(rs.next()) {
			batterybuilder.append(String.format("| %-20s | %-20s | %-20s | %-20d | %-20d | %-20d | %-20d |\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7)));
		}
		batterybuilder.append("******************************************************************************************************************************************************************").append("\n");
		System.out.println(batterybuilder.toString());
		System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
		String ch=sc.next();
		if(ch.equals("y"))
		{
			admin_mode();
		}
		else
		{
			main_menu();
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//THIS METHOD IS USED TO DISPLAY THE PRICE LIST OF BATTERY
	
	public void disp_batterylist_database() throws Exception {                                         
			Connection con=DButil.getConnection();
			Statement st=con.createStatement();
			try {
			ResultSet rs=st.executeQuery("select * from battery");
			System.out.println("Battery Database:\n");
			StringBuilder batterybuilder=new StringBuilder();
			batterybuilder.append("*******************************************************************************************************************************************").append("\n");
			batterybuilder.append(String.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n","Battery_id","Car Brand","Model","Warranty","Amps","Price"));
			batterybuilder.append("*******************************************************************************************************************************************").append("\n");
			while(rs.next()) {
				batterybuilder.append(String.format("| %-20s | %-20s | %-20s | %-20d | %-20d | %-20d |\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(7)));
			}
			batterybuilder.append("*******************************************************************************************************************************************").append("\n");
			System.out.println(batterybuilder.toString());
			System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
			String ch=sc.next();
			if(ch.equals("y"))
			{
				user_mode();
			}
			else
			{
				main_menu();
			}
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//THIS METHOD WILL SELL THE BATTERY BY CHECKING QUANTITY AND THROWS EXCEPTION
	
	public void sales_Battery(String battery_id,int quantity) throws ClassNotFoundException, SQLException, StockUnavailableException {              
		try {
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select quantity from battery where battery_id='"+battery_id+"'");
		if(rs.next()) {
			int currentQuantity = rs.getInt("quantity");
			rs.close();
            if (currentQuantity >= quantity) {
                int newQuantity = currentQuantity - quantity;
                st.executeUpdate("UPDATE Battery SET quantity=" + newQuantity +" WHERE battery_id = '"+battery_id+"'");
            }
            else {
        	throw new StockUnavailableException("Stock is unavailable!");
        	}
		}
		}
		catch(StockUnavailableException e) {
			System.out.println(e);
		}
	}
	
	//THIS METHOD IS USED TO RESTOCK THE BATTERY
	
	public void restock_Batteries(String battery_id) throws Exception {                                                    //Re stock the battery
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		st.executeUpdate("UPDATE Battery SET quantity=5 where battery_id='"+battery_id+"'");
		System.out.println("Stock is reloaded!");
		System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
		String ch=sc.next();
		if(ch.equals("y"))
		{
			admin_mode();
		}
		else
		{
			main_menu();
		}
	}
	
	//THIS METHOD IS USED TO GENERATE BILL FOR CUSTOMER
	
	public void customer_bill_db(String name,String address,String Mobile,String GstNo,String battery_id,int quantity) throws Exception{       //inserting customer details
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		CustomerDetails c=new CustomerDetails(name,address,Mobile,GstNo); 
	    st.execute("create table if not exists customer_bill (BillNo int AUTO_INCREMENT PRIMARY KEY,BillingDate date,CustomerName varchar(50) NOT NULL ,Address varchar(20) NOT NULL,MobileNumber varchar(20) NOT NULL ,GSTNo varchar(25),battery varchar(20),quantity int NOT NULL)");
		LocalDate date=LocalDate.now();
		PreparedStatement pst=con.prepareStatement("insert into customer_bill(BillingDate,CustomerName,Address,MobileNumber,GSTNo,battery,quantity) values(?,?,?,?,?,?,?)");
		pst.setDate(1,Date.valueOf(date));
		pst.setString(2, c.getCustomerName());
		pst.setString(3, c.getAddress());
		pst.setString(4, c.getMobileNo());
		pst.setString(5, c.getGstNo());
		pst.setString(6,battery_id);
		pst.setInt(7, quantity);
		pst.executeUpdate();
	}
	
	//THIS METHOD IS USED TO RETRIEIVE THE LAST INSERTED KEY
	
	public int getLastInsertedKey() throws SQLException, ClassNotFoundException {
		Connection con=DButil.getConnection();
	    int lastInsertedKey = -1;
	    try (Statement st = con.createStatement()) {
	    	ResultSet rs = st.executeQuery("SELECT BillNo FROM customer_bill ORDER BY BillNo DESC LIMIT 1");
	        if (rs.next()) {
	            lastInsertedKey = rs.getInt(1);
	        }
	    }
	    return lastInsertedKey;
	}
	
	//THIS METHOD IS TO PURCHASE BATTERY
	
	public void purchasing_battery() throws Exception {                       
		System.out.println("Enter the Customer Name:");
		String name=sc.next();
		sc.nextLine();
		System.out.println("Enter the address: ");
		String address=sc.nextLine();
		System.out.println("Enter Mobile Number: ");
		String mobile=sc.next();
		System.out.println("Enter GST Number: ");
		String gstNo=sc.next();
		System.out.println("Enter the Battery_id: ");
		String battery=sc.next();	
        System.out.println("Enter the Quantity: ");
        int quantity=sc.nextInt();
        sales_Battery(battery,quantity);
        customer_bill_db(name,address,mobile,gstNo,battery,quantity);
        int billno=getLastInsertedKey();
        generate_bill(billno);
        
    }
	
	//THIS METHOD IS TO CALCULATE BILL WITH GST TAX
	
	public void calculate_bill(int quantity,int price) {                   
		int total=quantity*price;
		double gstamt=(total/100)*28;
		double totalbill=total+(gstamt);
		cb.setTotal(totalbill);	
		cb.setGstTax(gstamt);
	}
	
	//THIS METHOD IS TO GENERATE BILL
	
	public void generate_bill(int billno) throws ClassNotFoundException, SQLException {                   
		Connection con=DButil.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from customer_bill where BillNo=?");
		pst.setInt(1, billno);
		ResultSet rs=pst.executeQuery();
		StringBuilder bill=new StringBuilder();
		int price=0;
		if(rs.next()) {
		bill.append("---------------------------------------------------------------------------------------").append("\n");
		bill.append("|                                AUTO ELECTRICALS RECIPT                              |").append("\n");
		bill.append("---------------------------------------------------------------------------------------").append("\n");
		bill.append("BillNO: ").append(billno).append("\n");
		bill.append("Date: ").append(rs.getDate("billingdate")).append("\n");
		bill.append("Name: ").append(rs.getString("CustomerName")).append("\n");
        bill.append("Address: ").append(rs.getString("address")).append("\n");
        bill.append("PhoneNo: ").append(rs.getString("MobileNumber")).append("\n");
        bill.append("GST No: ").append(rs.getString("GSTNo")).append("\n");
        bill.append("---------------------------------------------------------------------------------------").append("\n");
        bill.append(String.format("| %-52s | %-10s | %-15s |\n","Product","Quantity","Product Price"));
        bill.append("---------------------------------------------------------------------------------------").append("\n");
        PreparedStatement pst2=con.prepareStatement("select * from battery where battery_id=?");
        int quantity=rs.getInt("quantity");
        pst2.setString(1,rs.getString("battery"));
        ResultSet rs2=pst2.executeQuery();
        while(rs2.next()) {
        	price=rs2.getInt("price");
        }
        bill.append(String.format("| %-52s | %-10s | %-15s |\n",rs.getString("battery"),quantity,price));
        calculate_bill(quantity,price);
        int total=quantity*price;
        bill.append("---------------------------------------------------------------------------------------").append("\n");
        bill.append(String.format("  %-65s   %-15d  \n","ProductPrice",total));
        bill.append(String.format("  %-65s  +%-15.2f  \n","IGST",cb.getGstTax()));
        bill.append("---------------------------------------------------------------------------------------").append("\n");
        bill.append(String.format("  %-65s   %-15.2f  \n","Total",cb.getTotal()));
        bill.append("---------------------------------------------------------------------------------------").append("\n");
        System.out.println(bill.toString());
		}
	}
	
	//THIS METHOD CONTAINS THE PROCESS OF USER SIGN UP
	
	public void user_Signup()throws Exception {                                                           
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		try {
		String username;
		String password;
		System.out.println("Enter username: ");
		username=sc.next();
		System.out.println("Enter the password: ");
		password=sc.next();
		System.out.println("Enter your Age: ");
		int age=sc.nextInt();
		System.out.println("Enter your Gender: ");
		String gender=sc.next();
		u=new User(username,password,age,gender);
		st.execute("create table if not exists users (username varchar(20) PRIMARY KEY,password varchar(20),age int NOT NULL,gender varchar(10) NOT NULL)");
        if(!password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*") ) {
            throw new PasswordInvalidException("Password should contain at least one uppercase letter one digit.");
        }
        st.executeUpdate("INSERT INTO users VALUES ('" + u.getUsername() + "', '" + u.getPassword() + "',"+u.getAge()+",'"+u.getGender()+"')");
        System.out.println("Signup successful. ");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.print("Do you want to continue or return to main menu (y/n) respectively  : ");
		String ch=sc.next();
		if(ch.equals("y"))
		{
			u_user_login();
		}
		else
		{
			main_menu();
		}
		
	}
	
	//THIS METHOD CONTAINS THE PROCESS OF USER LOG IN
	
	public int user_Login()throws SQLException, ClassNotFoundException {
		Connection con=DButil.getConnection();
		Statement st=con.createStatement();
		String username;
		String password;
		System.out.println("Enter username: ");
		username=sc.next();
		System.out.println("Enter the password: ");
		password=sc.next();
		u=new User(username,password);
        ResultSet rs = st.executeQuery("SELECT password FROM users WHERE username = '" + u.getUsername() + "'");
        if (rs.next()) {
            String storedPassword = rs.getString("password");
            if (u.getPassword().equals(storedPassword)) {
                return 1;
            } 
            else {
            	return 0;
            }
        }
        else {
        	return 0;
        }
    }	
}
