package shopManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_bill {
int bill_id;
String customer_name;
double purchased_amount;
public Update_bill(int bill_id, String customer_name, double purchased_amount) {
	super();
	this.bill_id = bill_id;
	this.customer_name = customer_name;
	this.purchased_amount = purchased_amount;
}
public int getBill_id() {
	return bill_id;
}
public void setBill_id(int bill_id) {
	this.bill_id = bill_id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public double getPurchased_amount() {
	return purchased_amount;
}
public void setPurchased_amount(double purchased_amount) {
	this.purchased_amount = purchased_amount;
}
public void add_bill(Connection con) throws SQLException
{
	String query="select purchased_amount from bill_details where bill_id="+bill_id;
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	boolean b=false;
	while(rs.next())
	{
		purchased_amount+=rs.getDouble(1);
		b=true;
	}
	if(b)
	{
		query="update bill_details set purchased_amount="+purchased_amount+"where bill_id="+bill_id;
		st.executeUpdate(query);
	}
	else
	{
		query="insert into bill_details values ("+bill_id+",'"+customer_name+"',"+purchased_amount+")";
		st.execute(query);
	}
	
}
}
