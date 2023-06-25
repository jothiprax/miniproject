package project12;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class OrderDAO {
	private connectionclass DBConnectionn;
	public  OrderDAO() {
		 DBConnectionn =new  connectionclass();
		}
	    public void addOrder(Order order) {
	        try (Connection con= DBConnectionn.getConnection())
	        {
	             PreparedStatement statement = con.prepareStatement("INSERT INTO orders (id, customerName) VALUES (?, ?)");
	            statement.setInt(1, order.getId());
	            statement.setString(2, order.getCustomerName());
	            statement.executeUpdate();
	            System.out.println("Order added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateOrder(Order order) {
	        try (Connection con= DBConnectionn.getConnection();
	             PreparedStatement statement = con.prepareStatement("UPDATE orders SET customerName = ? WHERE id = ?")) {
	            statement.setString(1, order.getCustomerName());
	            statement.setInt(2, order.getId());
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Order updated successfully.");
	            } else {
	                System.out.println("Failed to update order. Order ID not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removeOrder(int orderId) {
	        try (Connection con = DBConnectionn.getConnection()){
	             PreparedStatement statement = con.prepareStatement("DELETE FROM orders WHERE id = ?");
	            statement.setInt(1, orderId);
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Order removed successfully.");
	            } else {
	                System.out.println("Failed to remove order. Order ID not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Order getOrderById(int orderId) {
	        try (Connection con = DBConnectionn.getConnection()){
	             PreparedStatement statement = con.prepareStatement("SELECT * FROM orders WHERE id = ?");
	            statement.setInt(1, orderId);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String customerName = resultSet.getString("customerName");
	                return new Order(id, customerName);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public MenuItem getMenuItemById(int menuItemId) {
	        try (Connection con = DBConnectionn.getConnection()){
	             PreparedStatement statement = con.prepareStatement("SELECT * FROM menu_items WHERE id = ?");
	            statement.setInt(1, menuItemId);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                double price = resultSet.getDouble("price");
	                return new MenuItem(id, name, price);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public void addMenuItem(MenuItem menuItem) {
	        try (Connection con = DBConnectionn.getConnection();
	             PreparedStatement statement = con.prepareStatement("INSERT INTO menu_items (id, name, price) VALUES (?, ?, ?)")) {
	            statement.setInt(1, menuItem.getId());
	            statement.setString(2, menuItem.getName());
	            statement.setDouble(3, menuItem.getPrice());
	            statement.executeUpdate();
	            System.out.println("Menu item added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removeMenuItem(int menuItemId) {
	        try (Connection con = DBConnectionn.getConnection();
	             PreparedStatement statement = con.prepareStatement("DELETE FROM menu_items WHERE id = ?")) {
 	            statement.setInt(1, menuItemId);
	         statement.executeUpdate();
	                System.out.println("Menu item removed successfully.");
	        }
	                catch (SQLException e) {
	    	            e.printStackTrace();
	    	        
	        }
	        }
	    public List<Order> getAllOrders() {
	        List<Order> orders = new ArrayList<>();
	        try (Connection con = DBConnectionn.getConnection()){
	             Statement statement = con.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
	            while (resultSet.next()) {
	                int id = resultSet.getInt(1);
	                String customerName = resultSet.getString(2);
	                Order order = new Order(id, customerName);
	                orders.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orders;
	        
	    }
	    public List<MenuItem> getAllMenuItems() {
	        List<MenuItem> menuItems = new ArrayList<>();
	        try (Connection con = DBConnectionn.getConnection()){
	             Statement statement = con.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM menu_items");
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                double price = resultSet.getDouble("price");
	                MenuItem menuItem = new MenuItem(id, name, price);
	                menuItems.add(menuItem);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return menuItems;
	    }
}