import java.lang.*;

public interface ITransactions
{
	void withdraw(double amount);
	void deposit(double amount);
	void transfer(Account a, double amount);
}