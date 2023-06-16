package mini_project_1;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		System.out.println("Welcome!!!");
        ration_process rp=new ration_process();
        
     rp.display_products();
      
      rp.pay(rp.cal2(rp.cal(rp.buy())));
      
      
	}

}
