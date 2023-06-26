import java.sql.*;
import java.util.*;

class InvalidUserNameException extends Exception
{
    public InvalidUserNameException(String message)
    {
        super(message);
    }
}
class InvalidPasswordException extends Exception
{
    public InvalidPasswordException(String message)
    {
        super(message);
    }
}
class InsufficientBalanceException extends Exception
{
    public InsufficientBalanceException(String message)
    {
        super(message);
    }
}

class User{
    private String userName;
    private String password;
    private double balance=0.0;

    public User(String userName,String password,double balance)
    {
        this.userName=userName;
        this.password=password;
        this.balance=balance;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount)
    {
        balance-=amount;
    }
    public void deposit(double amount)
    {
        balance+=amount;
    }
}
class OnlineBanking{
    Connection con;
    Statement st;
    ResultSet rs;
    Scanner sc = new Scanner(System.in);
    public OnlineBanking()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Vasanth08@");
            st=con.createStatement();
            st.executeUpdate("Use MINI");
            //con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public OnlineBanking(int x)
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Vasanth08@");
            st=con.createStatement();
            st.executeUpdate("Use MINI");
            //st.execute("Create table Account(AccountHolderName varchar(20),AccountNumer varchar(20),UserName varchar(20),Balance double,Password varchar(20))");
           // con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void registerUser(String userName,String password)
    {
       try {
        st = con.createStatement();
        rs = st.executeQuery("Select userName from Accountss where userName= '"+userName+"'");
        if(!rs.next())
        {
            PreparedStatement register = con.prepareStatement("Insert into Accountss values(?,?,?,?,?)");
            System.out.print("Enter your name:");
            String name=sc.nextLine();
            System.out.print("Enter your account number:"); 
            String accountNumber=sc.nextLine();
            register.setString(1, name);
            register.setString(2, accountNumber);
            register.setString(3, userName);
            register.setDouble(4, 0.0);
            register.setString(5, password);
            int rows=register.executeUpdate();
            if(rows>0)
            {
                System.out.println("The user "+userName+" is created");
            }
            else
            {
                System.out.println("User not created");
            }
            rs.close();
            st.close();
            con=null;
        }
        else
        {
            System.out.println("User already exists. Enter a new User name.");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int logIn(String userName,String password) throws InvalidUserNameException,InvalidPasswordException
    {
        try{
            st = con.createStatement();
            rs = st.executeQuery("Select userName from Accountss where userName= '"+userName+"'");
            if(rs.next())
            {
                ResultSet pwd = st.executeQuery("Select userName from Accountss where password= '"+password+"'");
                if(!pwd.next())
                {
                    throw new InvalidPasswordException("Incorrect Password");
                }
                else{
                    System.out.println("Your account has looged inn....");
                    return 1;
                }
            }
            else
            {
                throw new InvalidUserNameException("Invalid User name:"+userName);
            }
        }
        catch(InvalidUserNameException e)
        {
        System.out.println(e.getMessage());
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public void withdraw(String userName,double amount) throws InsufficientBalanceException,InvalidPasswordException
    {
        try{
            if(con!=null){
            PreparedStatement wd = con.prepareStatement("Update Accountss set balance = balance - ? where userName = ? and balance >= ?");
            wd.setDouble(1, amount);
            wd.setString(2, userName);
            wd.setDouble(3, amount);
            System.out.print("Enter your password:");
            String password=sc.nextLine();
            st= con.createStatement();
            rs=st.executeQuery("select password from Accountss where userName='"+userName+"'");
            rs.next();
            if(!rs.getString(1).equals(password))
            {
                throw new InvalidPasswordException("You have entered a incorrect password");
            }
            else
            {
                int rows=wd.executeUpdate();
                if(rows==0)
                {
                    throw new InsufficientBalanceException("Your account does not have enough amount to withdraw");
                }
                else
                {
                    System.out.println("Amount withdrawn");
                }
            }
            }
            else
            {
                System.out.println("Please login first");
            }
        }
        catch(InsufficientBalanceException e)
        {
        System.out.println(e.getMessage());
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deposit(String userName,double amount) throws InvalidPasswordException
    {
        try{
            PreparedStatement dp = con.prepareStatement("Update Accountss set balance = balance + ? where userName = ?");
            dp.setDouble(1, amount);
            dp.setString(2, userName);
            System.out.print("Enter your password:");
            String password=sc.nextLine();
            st= con.createStatement();
            rs=st.executeQuery("select password from Accountss where userName='"+userName+"'");
            rs.next();
            if(!rs.getString(1).equals(password))
            {
                throw new InvalidPasswordException("You have entered a incorrect password");
            }
            else
            {
                int rows=dp.executeUpdate();
                if(rows==0)
                {
                    System.out.println("Something went wrong :(");
                }
                else
                    System.out.println("Amount deposited");
            }
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void transfer(String sender,String receiver,double amount) throws InvalidPasswordException,InsufficientBalanceException
    {
        try
        {
            withdraw(sender, amount);
            System.out.println("Please wait while your transaction is being processing");
            deposit(receiver, amount);
            System.out.println("Transaction completed");
        }
         catch(InsufficientBalanceException e)
        {
        System.out.println(e.getMessage());
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
    }  
    
    public void checkBalance(String userName) throws InvalidPasswordException
    {
        try
        {
            PreparedStatement bal=con.prepareStatement("Select balance from Accountss where username=?");
            bal.setString(1, userName);
            System.out.print("Enter your password:");
            String pass=sc.nextLine();
            st= con.createStatement();
            rs=st.executeQuery("select password from Accountss where userName="+"'"+userName+"'");
            rs.next();
            if(!rs.getString(1).equals(pass))
            {
                throw new InvalidPasswordException("You have entered a incorrect password");
            }
            else if(rs.getString(1).equals(pass))
            {
                rs=bal.executeQuery();
                if(rs.next())
                {
                    System.out.println("Your account balance is: Rs."+rs.getDouble(1));
                }
            }
            else{
                throw new InvalidUserNameException("You have entered a incorrect username");
            }
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
        catch(InvalidUserNameException e)
        {
        System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void accountDetails(String userName) throws InvalidPasswordException
    {
        try{
            PreparedStatement detail=con.prepareStatement("Select * from Accountss where userName= ?");
            detail.setString(1, userName);
            System.out.print("Enter your password:");
            String pass=sc.nextLine();
            st= con.createStatement();
            rs=st.executeQuery("select password from Accountss where userName='"+userName+"'");
            rs.next();
            if(!rs.getString(1).equals(pass))
            {
                throw new InvalidPasswordException("You have entered a incorrect password");
            }
            else
            {
                rs=detail.executeQuery();
                while(rs.next())
                {
                    System.out.println("UserName:"+rs.getString(3));
                    System.out.println("Balance:Rs."+rs.getDouble(4));
                    System.out.println("AccountHolderName:"+rs.getString(1));
                    System.out.println("Account Number:"+rs.getString(2));
                }
            }
        }
        catch(InvalidPasswordException e)
        {
        System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void logOut()
    {
        try {
            rs.close();
            st.close();
            con.close();
            con=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}