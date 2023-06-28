import java.sql.*;

public class VegMenu extends HotelServies{

        public VegMenu()
        {
            super();
        }
       public void Insert_veg() {
        String url = "jdbc:mysql://localhost:3306/mouli";
        String name = "root";
        String password = "1234";

        try {
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement stm = con.prepareStatement("insert into VegFood values(?,?,?)");
            stm.setString(1,"pongal");
            stm.setInt(2,10);
            stm.setInt(3,20);
            stm.executeUpdate();
            stm.setString(1, "poori");
            stm.setInt(2, 10);
            stm.setInt(3, 10);
            stm.executeUpdate();
            stm.setString(1, "vada");
            stm.setInt(2, 20);
            stm.setInt(3, 10);
            stm.executeUpdate();
            stm.setString(1, "dosa");
            stm.setInt(2, 10);
            stm.setInt(3, 30);
            stm.executeUpdate();
            stm.setString(1, "idly");
            stm.setInt(2, 30);
            stm.setInt(3, 5);
            stm.executeUpdate();
            stm.setString(1, "veg Rice");
            stm.setInt(2, 30);
            stm.setInt(3, 5);
            stm.executeUpdate();
            stm.setString(1, "veg Noodels");
            stm.setInt(2, 30);
            stm.setInt(3, 5);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void display()
    {
        String url = "jdbc:mysql://localhost:3306/mouli";
        String name = "root";
        String password = "1234";
        try{
            Connection con = DriverManager.getConnection(url, name, password);
            Statement stm =con.createStatement();
            ResultSet res=stm.executeQuery("select * from VegFood");
            int i=0;
            while(res.next())
            {
                System.out.printf("%d  %-20s\n",++i,res.getString(1));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public int calculate(String product,int qua)
    {
        int p=0;
        int q=0;
        String url = "jdbc:mysql://localhost:3306/mouli";
        String name = "root";
        String password = "1234";
        try {
            Connection con = DriverManager.getConnection(url, name, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select price,food_Quantity from vegFood where food_name = " + "'" + product + "'");
            while (rs.next()) {
                p = rs.getInt(1);
                q = rs.getInt(2);
            }
            q = q - qua;
            if(q<0)
            {
                throw  new OutOfStackException();
            }
            else {
                PreparedStatement stm = con.prepareStatement("update vegFood set food_Quantity=? where food_name= " + "'" + product + "'");
                if(q>=0)
                stm.setInt(1, q);
                else
                stm.setInt(1,0);
                stm.executeUpdate();
            }
        }
        catch (OutOfStackException e)
        {
            e.outOfStackException();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        if(q<0)
        {
            try{
                Connection con1 = DriverManager.getConnection(url, name, password);
                Statement stm = con1.createStatement();
                ResultSet rs = stm.executeQuery("select  Food_name,food_Quantity from vegFood");
                System.out.println("     -->      avalible food are    <--");
                System.out.printf("%-20s%s\n","Food Name","Quantity");
                while(rs.next()) {
                   System.out.printf("%-20s",rs.getString(1)); 
                   System.out.println(rs.getInt(2));
                }
            }
            catch(Exception e)
            {

            }
        }
        if(q<0)
        return 0;
        else
        return p;
    }
}
