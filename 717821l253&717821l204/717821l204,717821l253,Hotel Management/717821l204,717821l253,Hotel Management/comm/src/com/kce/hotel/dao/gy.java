import java.sql.*;
import java.util.Scanner;

public class FoodManagement {
    static final String DB_URL = "jdbc:mysql://localhost/food_db";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            while (true) {
                System.out.println("1. Add Food Item");
                System.out.println("2. Search Food Item");
                System.out.println("3. Delete Food Item");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter food name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter food price: ");
                        double price = scanner.nextDouble();
                        addFoodItem(statement, name, price);
                        break;

                    case 2:
                        System.out.print("Enter food name to search: ");
                        String searchName = scanner.nextLine();
                        searchFoodItem(statement, searchName);
                        break;

                    case 3:
                        System.out.print("Enter food name to delete: ");
                        String deleteName = scanner.nextLine();
                        deleteFoodItem(statement, deleteName);
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        statement.close();
                        connection.close();
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void addFoodItem(Statement statement, String name, double price) throws SQLException {
        String sql = "INSERT INTO food_items (name, price) VALUES ('" + name + "', " + price + ")";
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Failed to add food item.");
        }
    }

    private static void searchFoodItem(Statement statement, String searchName) throws SQLException {
        String sql = "SELECT * FROM food_items WHERE name LIKE '%" + searchName + "%'";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
        }
    }

    private static void deleteFoodItem(Statement statement, String deleteName) throws SQLException {
        String sql = "DELETE FROM food_items WHERE name = '" + deleteName + "'";
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Food item deleted successfully!");
        } else {
            System.out.println("Food item not found.");
        }
    }
}