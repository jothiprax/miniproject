package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankSystem {
		int number;
		String holder;
		double balance;
		public BankSystem(int number, String holder, double balance) {
			this.number = number;
			this.holder = holder;
			this.balance = balance;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getHolder() {
			return holder;
		}
		public void setHolder(String holder) {
			this.holder = holder;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public void add() throws SQLException
		{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/kodi","root","kodi@123");
			String query="insert into Bank values("+number+",'"+holder+"',"+balance+");";
			Statement st=c.createStatement();
			st.execute(query);
		}
		

	}
