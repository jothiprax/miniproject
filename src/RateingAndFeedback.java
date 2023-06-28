import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RateingAndFeedback {
    public void feed() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please fill the feedback Form:");
            System.out.println("Enter the Rating 1 to 5");
            int a = sc.nextInt();
            sc.nextLine();
            System.out.println("suggestion");
            String str = sc.nextLine();
            String url = "jdbc:mysql://localhost:3306";
            String name = "root";
            String password = "Yogesh@123";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                PreparedStatement stm = con.prepareStatement("insert into feedback values(?,?)");
                stm.setInt(1, a);
                stm.setString(2, str);
                stm.execute();
            } catch (Exception e) {

            }
        }
    }
}
