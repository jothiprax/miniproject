package VN;
import java.util.*;
public class Array {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int arr[]=new int[5];	
	for(int i=0;i<5;i++)
	{
		arr[i]=sc.nextInt();
		
	}
	for(int i=arr.length-1;i>=0;i--)
	{
		System.out.println(arr[i]);
	}

	int count=0;
	for(int i=0;i<arr.length;i++)
	{
		if(arr[i]%2==0)
		{
			//System.out.println(arr[i]);
			count++;
		}
	}
	System.out.println(count);
}
}
