import java.sql.*;
import java.util.Scanner;
public class Datastore {
    public static void main(String[] args)throws Exception{
        connect();
    }
    public static void connect() throws Exception{
        try{
            String url="jdbc:mysql://localhost:3306/speedycart";
            Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
            Statement state = conn.createStatement();
            System.out.println("connection successful!!");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public  void showuserdetails() throws Exception{
        try{
            String url="jdbc:mysql://localhost:3306/speedycart";
            Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
            Statement state = conn.createStatement();
            String query="select * from user";
            ResultSet rs = state.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
    }
        }catch (Exception e) {
            System.out.println(e);
   }

}
public void showproductdetails() throws Exception{
        try{
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    String query="select * from product";
    ResultSet rs = state.executeQuery(query);
    while (rs.next()){
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getInt(5));
    }
        }catch (Exception e) {
            System.out.println(e);
   }

}
public void order() throws Exception{
        try{
            Scanner scanner = new Scanner(System.in);
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    System.out.println("PLACE YOUR ORDER!!!");
    System.out.println("enter user id:");
    int id=scanner.nextInt();
    System.out.println("enter the user name:");
    String name=scanner.nextLine();
    System.out.println("enter the contact number:");
    int num=scanner.nextInt();
    System.out.println("enter the country:");
    String country=scanner.next();
    System.out.println("enter the productname:");
    String product=scanner.next();
    System.out.println("enter the quantity:");
        int quantity=scanner.nextInt();
        String query="insert into orderdetails values(?,?,?,?,?,?)";
        rs.getInt(id);
        rs.getString(name);
        rs.getInt(num);
        rs.getString(country);
        rs.getString(product);
        rs.getInt(quantity);
        ResultSet rs = state.executeQuery();


        }catch (Exception e) {
            System.out.println(e);
   }

}
}