import java.lang.*;
import java.util.Scanner;
import java.io.File;

public class Start
{
	public static void main(String args[])
	{
		Bank b = new Bank();
		BankFile f = new BankFile();
		System.out.println("===== Welcome to ABC Bank =====");
		
		Scanner sin=new Scanner(System.in);
		int m[] = new int[10];
		int i,j,k;
		boolean repeat = true;
		boolean repeat1 = true;

		
		
		while(repeat1){
			
			System.out.println("What do you want to do?\n");
			System.out.println("1. Employee Management");
			System.out.println("2. Customer Management");
			System.out.println("3. Customer Account Management");
			System.out.println("4. Account Transaction");
			System.out.println("5. Exit\n"); 
		
			System.out.println("Choose: ");
			int choose=sin.nextInt();
			
			// For Employees
			if (choose == 1){
				
				f.write("=================Employeee Management=======\n");
				
				while(repeat){
				System.out.println("Employee Management");
				
				System.out.println("Choose any one Option\n");
				System.out.println("1.Insert New Employee");
				System.out.println("2.Removing an Existing Employee");
				System.out.println("3.Show All Employees");
				System.out.println("4.Main Menu\n");
				
				int option=sin.nextInt();
				
					if (option == 1){
						
						System.out.println("Insert New Employee");
						
						System.out.print("Enter Employee ID: ");
						String empId = sin.next();
						System.out.print("Enter Employee Name: ");
						String name = sin.next();
						System.out.print("Enter Employee Salary: ");
						double salary = sin.nextDouble();
						
						Employee e = new Employee();
						e.setEmpId(empId);
						e.setName(name);
						e.setSalary(salary);
						
						b.insertEmployee(e);
						f.write("Employee: "+empId+" Name: "+name+" Salary: "+salary+"\n");
						
						continue;		
				}
			
		
		
					if (option == 2){
						System.out.println("Which employee do you want to remove?");
						System.out.println("Employee ID:");
						String empId=sin.next();	
						
						Employee e = b.getEmployee(empId);
							if(e != null)
							{
								b.removeEmployee(e);
								
							}
						continue;
								
				}
				
							
					if (option == 3){
						b.showAllEmployees();
						
						continue;
								
						}
					
					
					if (option == 4){
						break;
								
						}
			
				}
				f.write("\r");
			}
				
				// For Customers
		
			if (choose == 2)
			{	
				f.write("=================Customer Management=======\n");

				while(repeat){
				System.out.println("Customer Management");
				
				System.out.println("Choose any one Option\n");
				System.out.println("1.Insert New Customer");
				System.out.println("2.Removing an Existing Customer");
				System.out.println("3.Show All Customer");
				System.out.println("4.Main Menu\n");
				
				
				int option=sin.nextInt();
				

					if (option == 1){
						
						System.out.println("Insert New Customer");
						
						System.out.print("Enter Customer NID: ");
						int nid = sin.nextInt();
						System.out.print("Enter Customer Name: ");
						String name = sin.next();
					
						
						Customer c = new Customer();
						c.setNid(nid);
						c.setName(name);
						b.insertCustomer(c);
						f.write("Customer NID: "+nid+" Name: "+name+"\n");

						
					continue;
					
				}
					if (option == 2){
						System.out.println("Which Customer do you want to remove?");
						System.out.println("Customer NID:");
						int nid =sin.nextInt();	
						
						Customer c = b.getCustomer(nid);
							if(c != null)
							{
								b.removeCustomer(c);
								
							}
							continue;
					
				}
				
							
					if (option == 3){
						b.showAllCustomers();
							continue;
						}
					
					if (option == 4){
						
						break;
					}
			
			}
			f.write("\r");
		}
				
				
			// Customer Account Management
		
			if (choose == 3)
			{	
				f.write("==============Account Infromation===============\r");
				while(repeat){
				System.out.println("Customer Account Management");
				
				System.out.println("Choose any one Option\n");
				System.out.println("1.Insert New Account");
				System.out.println("2.Removing an Existing Account");
				System.out.println("3.Show All Accounts");
				System.out.println("4.Main Menu\n");
				
				int option=sin.nextInt();
				
			
				if (option == 1){
					
					System.out.println("Insert New Account for a Customer");
					
					Account a = null;
					
					System.out.println("Which type of Account do you want to Create?\n");
					System.out.println("1. Savings Account");
					System.out.println("2. Fixed Account");
					
				
					System.out.print("Enter Type: ");
					int type = sin.nextInt();
					
					if(type == 1)
					{
						SavingsAccount sa = new SavingsAccount();
						System.out.print("Enter Account Number: ");
						int an = sin.nextInt();
						System.out.print("Enter Account Balance: ");
						double bl = sin.nextDouble();
						System.out.print("Enter Interest Rate: ");
						double ir = sin.nextDouble();
						
						sa.setAccountNumber(an);
						sa.setBalance(bl);
						sa.setInterestRate(ir);
						
						a = sa;

						f.write("Ac. No: "+an+" balance: " +bl+ " Interest Rate: "+ir);
		
						
						
					}
					else if(type == 2)
					{
						FixedAccount fa = new FixedAccount();
						
						System.out.print("Enter Account Number: ");
						int an = sin.nextInt();
						System.out.print("Enter Account Balance: ");
						double bl = sin.nextDouble();
						System.out.print("Enter Tenure Year: ");
						int ty = sin.nextInt();
						
						fa.setAccountNumber(an);
						fa.setBalance(bl);
						fa.setTenureYear(ty);
						
						a = fa;
						f.write("Ac. No: "+an+" balance: "+bl+" Tenure Year: "+ty);
					
						
					}
				
					
				if(a != null)
				{
					System.out.print("Enter Customer NID: ");
					int nid = sin.nextInt();
					b.getCustomer(nid).insertAccount(a);
					f.write(" Customer NID: "+nid+"\r");
					continue;
					
				}
			
			}
			
				if (option == 2){
					System.out.println("Remove an Account of a Customer");
					
					System.out.print("Enter Customer NID: ");
					int nid = sin.nextInt();
					System.out.print("Enter Account Number: ");
					int an = sin.nextInt();
					
					
					
					Customer c = b.getCustomer(nid);
					if(c != null){
						Account a = c.getAccount(an);
						
						if(a != null)
						{
							c.removeAccount(a);
							
						}
					}
					
				continue;
			}
		
				if (option == 3){
					System.out.println("Show All Accounts of a Customer");
						
					System.out.print("Enter Customer NID: ");
					int nid = sin.nextInt();
					
					b.getCustomer(nid).showAllAccounts();
					
					continue;
				}
				
				if (option == 4){
					
					break;
				}
			
			
			}
		}
			
			// Account Transactions
		
			if (choose == 4)
			{
				while(repeat){
				    System.out.println("Account Transactions");
					
					System.out.println("Choose any one Option:\n");
					System.out.println("1. Deposit Money");
					System.out.println("2. Withdraw Money");
					System.out.println("3. Transfer Money");
					System.out.println("4.Main Menu");
				
				   int option=sin.nextInt();
				
			
				if (option == 1){
					
					System.out.println("Deposit Money");
					System.out.print("Enter Customer NID: ");
					int nid = sin.nextInt();
					System.out.print("Enter Account Number: ");
					int an = sin.nextInt();
					System.out.print("Enter Deposit Amount: ");
					double amount = sin.nextDouble();
					
					if(amount>0)
					{
						b.getCustomer(nid).getAccount(an).deposit(amount);
					
					}
					
				}
			
				if (option == 2){
					
					System.out.println("Withdraw Money");
					System.out.print("Enter Customer NID: ");
					int nid = sin.nextInt();
					System.out.print("Enter Account Number: ");
					int an = sin.nextInt();
					System.out.print("Enter Withdraw Amount: ");
					double amount = sin.nextDouble();
					
					if(amount>0 && amount<=b.getCustomer(nid).getAccount(an).getBalance())
					{
						b.getCustomer(nid).getAccount(an).withdraw(amount);
					
					}
				
					
				continue;
			}
		
				if (option == 3){
					System.out.println("Transfer Money");
					System.out.print("Enter From Customer NID: ");
					int fromNid = sin.nextInt();
					System.out.print("Enter From Account Number: ");
					int fromAN = sin.nextInt();
					System.out.print("Enter Transfer Amount: ");
					double amount = sin.nextDouble();
					
					System.out.print("Enter To Customer NID: ");
					int toNid = sin.nextInt();
					System.out.print("Enter To Account Number: ");
					int toAN = sin.nextInt();
					
					if(amount>0 && amount<=b.getCustomer(fromNid).getAccount(fromAN).getBalance())
					{
						b.getCustomer(fromNid).getAccount(fromAN).transfer(b.getCustomer(toNid).getAccount(toAN),amount);
					}
					continue;
				}
				
				if (option == 4){
					
					break;
				}
				
		
		}
	}
	
	//.............EXIT.............
	
		if (choose == 5)
		{
				System.out.println(".........Exit............");
				repeat1 = false;
				break;
		}
			
			
			    
			
		} 
		
	}
}
		 
