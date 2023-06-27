import java.lang.*;

public class Customer implements AccountOperations
{
	private String name;
	private int nid;
	private Account accounts[] = new Account [10];
	
	
	public void setName(String name){this.name = name;}
	public void setNid(int nid){this.nid = nid;}
	
	
	public String getName(){return name;}
	public int getNid(){return nid;}
	
	public void insertAccount(Account a)
	{
		int count = 0;
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] == null)
			{
				accounts[i] = a;
				count = 1;
				break;
			}
		}
		if(count == 1)
		{
			System.out.println("Account Inserted");
		}
		else
		{
			System.out.println("Can Not Insert");
		}
	}
	
	public void removeAccount(Account a)
	{
		int count = 0;
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] == a)
			{
				accounts[i] = null;
				count = 1;
				break;
			}
		}
		if(count== 1){System.out.println("Account Removed");}
		else{System.out.println("Can Not Remove");}
	}
	public void showAllAccounts()
	{
		for(Account a : accounts)
		{
			if(a != null)
			{
				a.showInfo();
			}
		}
	}
	public Account getAccount(int accountNumber)
	{
		Account a = null;
		
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] != null)
			{
				if(accounts[i].getAccountNumber() == accountNumber)
				{
					a = accounts[i];
					break;
				}
			}
		}
		if(a != null)
		{
			System.out.println("Account Found");
		}
		else
		{
			System.out.println("Account Not Found");
		}
		return a;
	}
}