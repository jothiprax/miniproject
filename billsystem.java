package electricitybilling;
import java.util.*;

class billsystem {
	public static void main(String[]args)
	{
			EBcustomer bill=new EBcustomer();
			bill.getdata();
			bill.calc();
			bill.display();
	}
}
	class EBcustomer
	{
		String customer_Name,customer_type;
		long ebill_no;
		double current_read,previous_read,total_amount,units;
		Scanner sc=new Scanner(System.in);
		void getdata()
		{
			System.out.println("Enter the type of connection(D for Domestic or C for commercial):");
			customer_type=sc.next();
			System.out.println("Enter customer number:");
			ebill_no=sc.nextLong();
			System.out.println("Enter the customer Name:");
			customer_Name=sc.next();
			System.out.println("Enter previous month reading:");
			previous_read=sc.nextDouble();
			System.out.println("Enter current month reading:");
			current_read=sc.nextDouble();
		}
		void calc()
		{
			if(previous_read<current_read)
			{
				units=current_read-previous_read;
				if(customer_type.equals("D"))
				{
					if(units<=100)
					{
						total_amount=units*1;
					}
					else if(units<=200)
					{
						total_amount=(100*1+(units-100)*2.50);
					}
					else if(units<=500)
					{
						total_amount=(100*1+100*2.50)+(units-200)*4;
					}
					else
					{
						total_amount=(100*1+100*2.50+300*4+(units-500)*6);
					}
				}
				else
				{
					if(units<=100)
					{
						total_amount=units*2;
					}
					else if(units<=200)
					{
						total_amount=(100*2+(units-100)*4.50);
					}
					else if(units<=500)
					{
						total_amount=(100*2+100*4.50)+(units-200)*6;
					}
					else
					{
						total_amount=(100*2+100*4.50+300*6+(units-500)*7);
					}
				}
			}
		}
		void display()
		{
			System.out.println("*********Electricity Billing System**********");
			System.out.println("Customer Number      = "+ebill_no);
			System.out.println("Customer Name        = "+customer_Name+"\n");
			
			if(customer_type.equals("D"))
			{
				System.out.println("Type of connection = DOMESTIC ");
			}
			else
			{
				System.out.println("Type of connection = COMMERCIAL ");
			}
			
			System.out.println("Current month reading = "+current_read);
			System.out.println("Previous month reading = "+previous_read);
			System.out.println("Units = "+units);
			System.out.println("Total Amount = Rs."+total_amount);
		}
	}