package com.kce.accountsdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.accounts.accounts;
public class accountsdao {
	public accountsdao()
	{
		
	}
	public boolean createaccount(accounts account)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			String query="insert into customer values(?,?,?,?,?,?,?)";
			PreparedStatement p=connection.prepareStatement(query);
			p.setString(1, accounts.getUsername());
			p.setString(2, accounts.getPassword());
			p.setString(3, accounts.getName());
			p.setLong(4,accounts.getPhno());
			p.setInt(5, accounts.getAge());
			p.setString(6, accounts.getGender());
			p.setString(7, accounts.getPlace());
			int row=p.executeUpdate();
			if(row==0)
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
