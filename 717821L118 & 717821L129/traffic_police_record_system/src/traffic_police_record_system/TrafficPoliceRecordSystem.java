package traffic_police_record_system;
import java.sql.*;
public class TrafficPoliceRecordSystem {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/traffic_records";
    static final String USER = "username";
    static final String PASS = "password";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE traffic_tickets " +"(id INT NOT NULL AUTO_INCREMENT, " +"license_plate VARCHAR(10) NOT NULL, " +"violation VARCHAR(100) NOT NULL, " +"fine_amount DOUBLE NOT NULL, " +"PRIMARY KEY (id))";
            stmt.executeUpdate(createTableSQL);
            String insertRecordSQL = "INSERT INTO traffic_tickets (license_plate, violation, fine_amount) " +"VALUES ('ABC123', 'Speeding', 100.0)";
            stmt.executeUpdate(insertRecordSQL);
            String selectRecordsSQL = "SELECT id, license_plate, violation, fine_amount FROM traffic_tickets";
            ResultSet rs = stmt.executeQuery(selectRecordsSQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String licensePlate = rs.getString("license_plate");
                String violation = rs.getString("violation");
                double fineAmount = rs.getDouble("fine_amount");
                System.out.println("ID: " + id);
                System.out.println("License Plate: " + licensePlate);
                System.out.println("Violation: " + violation);
                System.out.println("Fine Amount: " + fineAmount);
                System.out.println("-----------------------");
            }
            rs.close();
            stmt.close();
            conn.close();
        } 
        catch (SQLException se) {
            se.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
