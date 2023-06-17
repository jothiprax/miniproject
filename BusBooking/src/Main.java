import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main extends Choose {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
	try {
	BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
	   Choose c=new Choose();
	   c.choose();
	   choose=Integer.parseInt(sc.readLine());
	   if(choose==2) {
		Agent m=new Agent();
		m.display();
	   }
	   else if(choose==1) {
		Customer c1=new Customer();
		c1.display();
	   }
	   else if(choose==3) {
			Selection w=new Selection();
			w.Dispaly();
		   }
	   else {
		   System.out.println("Enter Invalid Input");
	   }
	   }
	catch(Exception e){
		System.out.println(e);
	}
	}
}