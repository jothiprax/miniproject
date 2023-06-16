package com.kce.dao;
import com.kce.service.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.kce.bean.*;
public class updateAnddelete {
	Connection co;
	public void Cal()
	{
		String up="update mode_of_transaction set Payment_Method='GPAY' where cust_id=202";
		try {
			Statement st =co.createStatement();
			st.executeUpdate(up);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String delete="delete from mode_of_transaction where cust_id=7";
		try {
			Statement t =co.createStatement();
			t.executeUpdate(delete);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
