package com.Kce.DAO;
import java.sql.*;
import com.Kce.util.*;
import com.Kce.bean.*;

public class BankDAO {
    public int generateTranscationid() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public void addAccount(AccountBean b) throws ClassNotFoundException, SQLException {
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        //Account Creation and Inserting account details into database
        PreparedStatement p = con.prepareStatement("insert into Account_tbl values(?,?,?,?,?)");
        p.setString(1, b.getAccount_number());
        p.setString(2, b.getCustomer_name());
        p.setFloat(3, b.getBalance());
        p.setString(4,b.getMPIN());
        p.setString(5,b.getMTPIN());
        p.executeUpdate();
        System.out.println("Account created Successfully");
        p.close();
        con.close();
    }

    public void deleteAccount(String delAccount) throws ClassNotFoundException, SQLException {
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        //Deleting account details from database
        s.executeUpdate("delete from Account_tbl where Account_number='" + delAccount + "'");
        System.out.println("Account Deleted Succesfully");
        s.close();
        con.close();
    }

    public boolean ValidateAccount(String Account_number) throws ClassNotFoundException, SQLException {
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        boolean v = false;
        ResultSet r = s.executeQuery("select Account_number from Account_tbl");
        while (r.next()) {
            if (Account_number.equals(r.getString(1))) {
                v = true;
            }
        }
        r.close();
        s.close();
        con.close();
        return v;
    }

    public float findBalance(String Account_number) throws ClassNotFoundException, SQLException {
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        float b = 0.0f;
        //To fetch Account balance from database
        ResultSet r = s.executeQuery("Select Balance from Account_tbl where Account_number='" + Account_number + "'");
        while (r.next()) {
            b = r.getFloat(1);
        }
        r.close();
        s.close();
        con.close();
        return b;
    }

    public boolean transferMoney(TransferBean t) throws ClassNotFoundException, SQLException {

        int f;
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        //To fetch Transfer details
        PreparedStatement p = con.prepareStatement("insert into Transfer_tbl values(?,?,?,?,?)");
        p.setInt(1, t.getTranscation_id());
        p.setString(2, t.getFromAccountNumber());
        p.setString(3, t.getToAccountNumber());
        p.setDate(4,t.getDateofTranscation());
        p.setFloat(5, t.getAmount());
        f = p.executeUpdate();
        p.close();
        con.close();
        if (f != 0)
            return true;
        else
            return false;
    }
    public String getMPIN(String ac)throws ClassNotFoundException,SQLException{
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        ResultSet r=s.executeQuery("Select MPIN from Account_tbl where Account_number='"+ac+"'");
        while(r.next()){
            return r.getString(1);
        }
        return "NO";
    }
    public String getMTPIN(String ac)throws ClassNotFoundException,SQLException{
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        ResultSet r=s.executeQuery("Select MTPIN from Account_tbl where Account_number='"+ac+"'");
        while(r.next()){
            return r.getString(1);
        }
        return "";
    }
    public void ResetMPIN(String ac,String mp)throws ClassNotFoundException,SQLException{
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        s.executeUpdate("update Account_tbl set MPIN='" + mp + "'where Account_number='" +ac+ "'");
        s.close();
        con.close();
    }
    public void ResetMTPIN(String ac,String mt)throws ClassNotFoundException,SQLException{
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        s.executeUpdate("update Account_tbl set MTPIN='" + mt + "' where Account_number='" +ac+ "'");
        s.close();
        con.close();
    }
    public void UpdateAccount_tbl(String Account_number, float newbal) throws ClassNotFoundException, SQLException {
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        //Update Account Details
        s.executeUpdate("update Account_tbl set Balance=" + newbal + "where Account_number='" + Account_number + "'");
        s.close();
        con.close();
    }

    public void DetailofAccount(String AccountNumber) throws ClassNotFoundException, SQLException {
        boolean p=true;
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("select * from Account_tbl where Account_number='"+AccountNumber+"'");
        System.out.println("ACCOUNT_NUMBER\tCUSTOMERNAME\tBALANCE\tMPIN\tMTPIN");
        while (r.next()) {
            p=false;
            System.out.println(r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getFloat(3)+"\t\t"+r.getString(4)+"\t\t"+r.getString(5));
        }
        if(p){
            System.out.println("No records are found\nCheck the Account number");
        }
        r.close();
        s.close();
        con.close();
    }

    public void DetailofTranscation(int tid) throws ClassNotFoundException, SQLException {
        boolean p=true;
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        //To fetch Transaction account details with Transaction id from database
        ResultSet r = s.executeQuery("select * from Transfer_tbl where Transcation_id="+tid);
        System.out.println("TranscationID\tAccountNumber\tBeneficiaryAccount\tTranscationDate\tTranscationAmount");
        while(r.next()){
            p=false;
            System.out.println(r.getInt(1)+"\t\t"+r.getString(2)+"\t\t"+r.getString(3)+"\t\t"+r.getDate(4)+"\t\t"+r.getFloat(5));
        }
        if(p){
            System.out.println("No records are found\nCheck the TranscationId");
        }
        r.close();
        s.close();
        con.close();
    }
    public void viewTranscation(String AC)throws ClassNotFoundException,SQLException{
        boolean pa=true;
        DBUtil d = new DBUtil();
        Connection con = d.getDBConnection();
        Statement s = con.createStatement();
        //To view Transaction Account details with account number
        ResultSet r=s.executeQuery("Select * from Transfer_tbl where Account_Number='"+AC+"' or Beneficiary_account_number='"+AC+"'");
        System.out.println("TransactionID\tAccountNumber\tBeneficiaryAccount\tTransactionDate\tTransactionAmount");
        while(r.next()){
            pa=false;
            System.out.println(r.getInt(1)+"\t\t"+r.getString(2)+"\t\t"+r.getString(3)+"\t\t"+r.getDate(4)+"\t\t"+r.getFloat(5));
        }
        if(pa){
            System.out.println("No records are found\nCheck the AccountNumber");
        }
        r.close();
        s.close();
        con.close();
    }
}