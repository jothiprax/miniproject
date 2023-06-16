package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;


public class DishesDAO {


public void InsertDishes()
{
try {
Connection con = DButil.getConnection();

//Values Insertion For Morning Dishes
PreparedStatement pmt = con.prepareStatement("insert into morningdishlist values(?,?)");
pmt.setString(1, "Dosa");
pmt.setDouble(2, 50.00);
pmt.executeUpdate();
pmt.setString(1, "Poori");
pmt.setDouble(2, 75.00);
pmt.executeUpdate();
pmt.setString(1, "Pongal With Vada");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Chola Puri");
pmt.setDouble(2, 100.00);
pmt.executeUpdate();
pmt.setString(1, "Paniyaram");
pmt.setDouble(2, 40.00);
pmt.executeUpdate();
pmt.setString(1, "Panner Dosa");
pmt.setDouble(2, 100.00);
pmt.executeUpdate();
pmt.setString(1, "IdiYappam");
pmt.setDouble(2, 50.00);
pmt.executeUpdate();

//Values Insertion For AfterNoon Dishes
pmt = con.prepareStatement("insert into afternoondishlist values(?,?)");
pmt.setString(1, "Meals");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Sambhar rice");
pmt.setDouble(2, 60.00);
pmt.executeUpdate();
pmt.setString(1, "Tamarind Rice");
pmt.setDouble(2, 55.00);
pmt.executeUpdate();
pmt.setString(1, "Veg Briyani");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Panneer Fried Rice");
pmt.setDouble(2, 120.00);
pmt.executeUpdate();
pmt.setString(1, "Mushroom Briyani");
pmt.setDouble(2, 120.00);
pmt.executeUpdate();
pmt.setString(1, "Curd Rice");
pmt.setDouble(2, 70.00);
pmt.executeUpdate();

//Values Insertion For Dinner Dishes
pmt = con.prepareStatement("insert into dinnerdishlist values(?,?)");
pmt.setString(1, "Masala Dosa");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Poori with Channa");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Parota");
pmt.setDouble(2, 25.00);
pmt.executeUpdate();
pmt.setString(1, "Chappati");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Veg Kothu Parota");
pmt.setDouble(2, 80.00);
pmt.executeUpdate();
pmt.setString(1, "Chilli Parota");
pmt.setDouble(2, 120.00);
pmt.executeUpdate();
pmt.setString(1, "Ghee Roast");
pmt.setDouble(2, 70.00);
pmt.executeUpdate();

} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
}



}
