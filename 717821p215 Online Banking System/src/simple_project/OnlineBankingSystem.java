package simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Main class
public class OnlineBankingSystem extends BankAccount
{
 public OnlineBankingSystem(String accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
		// TODO Auto-generated constructor stub
	}

public static void main(String[] args) 
 {
     try 
     {
         // Create a CheckingAccount object
         CheckingAccount checkingAccount = new CheckingAccount("1234567890", "John Doe", 1000.0, 500.0);
         checkingAccount.displayAccountInfo();

         // Withdraw from the account
         checkingAccount.withdraw(1500.0);

         // Create a SavingsAccount object
         SavingsAccount savingsAccount = new SavingsAccount("0987654321", "Jane Smith", 5000.0, 2.5);
         savingsAccount.displayAccountInfo();

         // Apply interest to the account
         savingsAccount.applyInterest();

         // Deposit into the account
         savingsAccount.deposit(1000.0);

         // Withdraw from the account
         savingsAccount.withdraw(3000.0);

         // Display the updated account information
         savingsAccount.displayAccountInfo();
     } 
     catch (InsufficientFundsException e) 
     {
         System.out.println(e);
     }
     try {
         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
         Statement statement = connection.createStatement();

         // Create accounts table if it doesn't exist
         statement.execute("CREATE TABLE IF NOT EXISTS accounts (account_number VARCHAR(10) PRIMARY KEY, account_holder VARCHAR(100), balance DOUBLE)");

         // Create a CheckingAccount object
         CheckingAccount checkingAccount = new CheckingAccount("1234567890", "John Doe", 1000.0, 500.0);
         checkingAccount.displayAccountInfo();
         checkingAccount.saveAccount(connection);

         // Withdraw from the account
         checkingAccount.withdraw(1500.0);

         // Create a SavingsAccount object
         SavingsAccount savingsAccount = new SavingsAccount("0987654321", "Jane Smith", 5000.0, 2.5);
         savingsAccount.displayAccountInfo();
         savingsAccount.saveAccount(connection);

         // Apply interest to the account
         savingsAccount.applyInterest();

         // Deposit into the account
         savingsAccount.deposit(1000.0);

         // Withdraw from the account
         savingsAccount.withdraw(3000.0);

         // Display the updated account information
         savingsAccount.displayAccountInfo();

         statement.close();
         connection.close();
     } catch (SQLException | InsufficientFundsException e) {
         e.printStackTrace();
     }

 }
}