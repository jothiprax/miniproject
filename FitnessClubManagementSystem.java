package FitnessClubManagementSystem;
import java.sql.*;
import java.util.Scanner;

public class FitnessClubManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try  {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Anas", "Anas");
            System.out.println("Fitness Club Management System\n");
            while (true) {
                System.out.println("1. Add Member");
                System.out.println("2. View Members");
                System.out.println("3. Remove member");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addMember(con, sc);
                        break;
                    case 2:
                        displayMembers(con);
                        break;
                    case 3:
                        removeMember(con,sc);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void addMember(Connection con, Scanner sc) throws Exception {
        System.out.println("Adding a new member\n");
        
        System.out.print("Enter member name: ");
        String name = sc.nextLine();
        System.out.print("Enter member age: ");
        int age = sc.nextInt();
        System.out.print("Enter member gender (M/F): ");
        String gender = sc.next();
        String sql = "INSERT INTO members  VALUES (?,?, ?, ?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, name);
            st.setInt(2, age);
            st.setString(3, gender);
            PreparedStatement pst = con.prepareStatement("select count(member_id) from members");
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                    st.setInt(4,rs.getInt(1)+1);
            }

            st.executeUpdate();
            System.out.println("Member added successfully.");
        }
    }
    private static void displayMembers(Connection con) throws Exception {
        System.out.println("Displaying all members\n");
        try (Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM members")) {
            while (resultSet.next()) {
                int memberId = resultSet.getInt("member_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.println("Member ID: " + memberId);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
            }
        }
    }
    private static void removeMember(Connection con,Scanner sc) throws Exception{
        PreparedStatement pst = con.prepareStatement("delete from members where member_id = ?");
        System.out.print("Enter the member id to remove : ");
        int memberId = sc.nextInt();
        pst.setInt(1,memberId);
        pst.executeUpdate();
        System.out.println("Member successfully removed");
    }
}