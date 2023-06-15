package COLAB;
import java.sql.*;
public class jdbcDemo {
public static void main(String args[]) throws SQLException {
	String url = "jdbc:mysql://localhost:3306/dummy";
	String user = "root";
	String pwd = "Lalidhesh24@";
	String query = "select * from stu";
       Connection con = DriverManager.getConnection(url,user,pwd);
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(query);
       while(rs.next()) {
    	   System.out.println("Name = "+rs.getString(1)+" ID = "+rs.getInt(2));
       }
       con.close();
}
}
