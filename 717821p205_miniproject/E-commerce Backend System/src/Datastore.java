import java.util.*;
import java.sql.*;
public class Datastore {
    public static void main(String[] args) throws Exception {
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
public  void showproductdetails() throws Exception{
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
public  void Insertproducts() throws Exception{
        try{
            Scanner scan=new Scanner(System.in);
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    System.out.println("Insertion of products:");
    System.out.println("enter the productname:");
    String name=scan.nextLine();
    System.out.println("enter the product cate:");
    String cate=scan.nextLine();
    System.out.println("enter the product price:");
    double price = scan.nextDouble();
    System.out.println("enter the product qty:");
    int qty=scan.nextInt();
    String query="insert into product(productname,category,price,quantity) values(?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1,name);
    ps.setString(2,cate);
    ps.setDouble(3,price);
    ps.setInt(4,qty);
     ps.executeUpdate();
        System.out.println("product Added!!");
        }catch (Exception e) {
            System.out.println(e);
   }
}
public void Userlogin() throws Exception{
        try{
            Scanner scan=new Scanner(System.in);
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    System.out.println("USER LOGIN:");
    System.out.println("enter the username:");
    String name=scan.nextLine();
    System.out.println("enter the contact:");
    String contact=scan.nextLine();
    System.out.println("enter the country:");
    String country = scan.nextLine();
    String query="insert into user(name,contact,country) values(?,?,?)";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1,name);
    ps.setString(2,contact);
    ps.setString(3,country);
    int rows = ps.executeUpdate();
        System.out.println("User created!!");
        }catch (Exception e) {
            System.out.println(e);
   }
}
public  void Order() throws Exception{
        try{
            Scanner scan=new Scanner(System.in);
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    System.out.println("ORDER DETAILS:");
    System.out.println("enter the username:");
    String name=scan.nextLine();
    System.out.println("enter the product to purchase:");
    String pname=scan.nextLine();
    String query="insert into orderdetails(username,productname) values(?,?)" ;
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1,name);
   //ps.setString(3,getUsercountry());
    //ps.setDouble(4,getUsercontact());
    ps.setString(2,pname);
     ps.executeUpdate();
    System.out.println("Order Placed!!!");
    System.out.println("Thank you for Shopping!!");
        }catch (Exception e) {
            System.out.println(e);
   }
}
public  void showorderdetails() throws Exception{
        try{
    String url="jdbc:mysql://localhost:3306/speedycart";
    Connection conn = DriverManager.getConnection(url,"root","Aniiruth");
    Statement state = conn.createStatement();
    String query="select * from orderdetails";
    ResultSet rs = state.executeQuery(query);
    while (rs.next()){
        System.out.println(rs.getString(1)+"  "+rs.getString(2));
    }
        }catch (Exception e) {
            System.out.println(e);
   }
}
}