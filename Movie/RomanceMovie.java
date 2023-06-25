package Movie;

import com.mysql.cj.conf.PropertyDefinitions;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class RomanceMovie extends MovieRental {

    public String movie;
    public String director;
    public int year, sno;
    public double imdb;
    public int price;

    public int quantity;
    public String genre;
    public String name;
    public RomanceMovie(int sno,String movie, String director, int year, double imdb, int price,int quantity,String genre) {
        this.sno=sno;
        this.movie = movie;
        this.director = director;
        this.year = year;
        this.imdb = imdb;
        this.price = price;
        this.quantity=quantity;
        this.genre=genre;
    }
    public RomanceMovie(String name){
        this.name=name;
    }
    public RomanceMovie(){}
    public String getCustomerMovie(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Name the Movie customer want?:");
        return scanner.nextLine();
    }

    public void UpdateQuery(ResultSet rs,Connection con){
        try{
            Statement st = con.createStatement();
            int quantity = rs.getInt(7)-1;
            st.executeUpdate("Update MovieDetails set quantity = " + "'" + quantity + "'" + "where sno = " + "'" + rs.getInt(1)+"'");
        }
        catch (Exception e){

        }
    }


    public void Insert(Connection con) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into MovieDetails values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, sno);
            pst.setString(2, movie);
            pst.setString(3, director);
            pst.setInt(4, year);
            pst.setDouble(5, imdb);
            pst.setInt(6, price);
            pst.setInt(7, quantity);
            pst.setString(8, genre);
            pst.executeUpdate();
        } catch (SQLException q) {
            q.printStackTrace();
        }
    }

    public void DBconnection(String selection) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVATRAIN", "root", "solomon@03");
            if (selection.equals("Insert")) {
                Insert(con);
            } else {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select * from MovieDetails where movie =" + "'" + name + "'");
                while (rs.next()) {
                    if (rs.getString(2).equals(name) && rs.getInt(7) != 0) {
                        System.out.println("Movie Details");
                        System.out.println("Movie: " + rs.getString(2));
                        System.out.println("Director: " + rs.getString(3));
                        System.out.println("Year: " + rs.getInt(4));
                        System.out.println("Imdb: " + rs.getDouble(5));
                        System.out.println("Price: " + rs.getInt(6));
                        System.out.println("Genre: " + rs.getString(8));
                        UpdateQuery(rs, con);
                    } else {
                        System.out.println("Out of Stock");
                    }
                }
            }
        } catch (SQLException a) {
            a.printStackTrace();
        }
    }
}