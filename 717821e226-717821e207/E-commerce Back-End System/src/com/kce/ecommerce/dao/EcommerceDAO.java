package com.kce.ecommerce.dao;
import com.kce.ecommerce.util.*;
import java.util.*;
import java.sql.SQLException;
import java.sql.*;
public class EcommerceDAO 
{

public boolean validateAccount(String username,String password)throws ClassNotFoundException,SQLException, UserNotException
{
	
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select  customername,password1 from contact");
		List<String>username1=new ArrayList<String>();
		List<String>password1=new ArrayList<String>();
		while(rs.next()) {
			username1.add(rs.getString(1));
			password1.add(rs.getString(2));
		}
if(username1.contains(username) && password1.contains(password))
{
	System.out.println("userfound");
}
else {
	throw new com.kce.ecommerce.util.UserNotException("no such user");
}
return false;
	
}
public void getCustomerDetails(String cName) throws ClassNotFoundException,SQLException {

	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select  customername,customermail,address from contact");
	while(rs.next()) {
		System.out.println("CustomerName: "+rs.getString(1)+"\nCustomerMailId: "+rs.getString(2)+"\nAddressLine: "+rs.getString(3));
	}

}
	
public void getOrderDetails(String productid) throws ClassNotFoundException,SQLException  {

	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select  productname,productid,orderid,orderstatus from contact");
	while(rs.next()) {
		System.out.println("ProductName: "+rs.getString(1)+"\nProductId: "+rs.getString(2)+"\nOrderId: "+rs.getString(3)+"\nOrderStatus: "+rs.getString(4));
	}
	
	
}
public void getProductDetails(String pname) throws ClassNotFoundException,SQLException {

	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select  productname,productid from contact where productname=(pname)");
	while(rs.next()) {
		System.out.println("ProductName: "+rs.getString(1)+"\nProductId: "+rs.getString(2));
	}
}
public void BuyProduct(String CName, String pname)throws ClassNotFoundException,SQLException  
{
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("insert into contact values(?)where customername=(?)");
	pst.setString(1,pname);
	pst.setString(2,CName);

	
}

	
}
