package OnlineShop.src.com.kce.services;

import java.io.IOException;
import java.sql.Connection;
import OnlineShop.src.com.kce.dao.*;
public class Application  {
    public static void main(String[] args) {
        try {
            Connection con =DatabaseConnection.makeDatabase();// connecting to the data base;
             
            if(con!=null){
            System.out.println("DATABASE CONNECTED SUCCESSFULLY.....\n");
            Shop.options();
            }
            else{
                System.out.println("DATABASE CONNECTION FAILED.....\n");
            }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }
    
}
