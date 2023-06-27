package simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class BankAccount 
{
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException 
    {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
public void saveAccount() throws SQLException 
{
	try {
	Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "pass");
    String query = "INSERT INTO accounts (account_number, account_holder, balance) VALUES (?, ?, ?)";
    PreparedStatement statement = connection1.prepareStatement(query);
    statement.setString(1, accountNumber);
    statement.setString(2, accountHolder);
    statement.setDouble(3, balance);
    statement.executeUpdate();
    statement.close();
    System.out.println("Account information saved to the database.");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}