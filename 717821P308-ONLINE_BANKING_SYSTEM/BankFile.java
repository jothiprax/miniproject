import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankFile
{	
		
		public void write(String s){
		try
		{
			FileWriter f =new FileWriter("Information.txt",true); 
			f.write(s); 
			f.close(); 
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found Exception");
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
		finally
		{
			//fout.close(); 
		}
	}		
		public void read(String s){
		try
		{
			FileReader inFile=new FileReader("Information.txt");
			Scanner sin=new Scanner(inFile);
			
		while(sin.hasNext())
		{
			s =sin.nextLine();
			System.out.println(s);
		}
		inFile.close();
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found Exception");
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
		finally
		{
			//fout.close(); 
		}

	}
}
