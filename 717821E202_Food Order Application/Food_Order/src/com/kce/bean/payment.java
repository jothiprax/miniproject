package com.kce.bean;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.dao.updateAnddelete;
import com.kce.service.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kce.service.LoginPage;
import com.kce.util.DBUtil;
import com.kce.util.WrongUpi;
import com.kce.util.incorrectLength;


class INCORRECTLENGTH extends Exception
{
	
}
public class payment extends JFrame implements ActionListener{
	JLabel j1,j2;
	JRadioButton r1,r2;
	ButtonGroup g;
	JTextField t,t1;
	JButton b,b1;
	Connection co;
	ResultSet rs=null;
	PreparedStatement ps=null;
	public payment() 
	{
		co=DBUtil.getConnection();
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
		j1=new JLabel("Payment Methods");
		j1.setBounds(400, 100, 250, 28);
		j1.setFont(new Font("",Font.BOLD,25));
		add(j1);
		g=new ButtonGroup();
		r1=new JRadioButton("UPI");
		r1.setBounds(310, 180, 60, 25);
		r1.setFont(new Font("",Font.ITALIC,20));
		add(r1);
		g.add(r1);
		j1=new JLabel("UPI-ID:");
		j1.setBounds(310, 220, 100, 20);
		j1.setFont(new Font("",Font.ITALIC,17));
		add(j1);
		t=new JTextField();
		t.setBounds(370, 220, 110, 20);
		add(t);
		b=new JButton("Pay Now");
		b.setBounds(310, 260, 170, 37);
		b.setFont(new Font("",Font.ITALIC,20));
		add(b);
		r2=new JRadioButton("Card");
		r2.setBounds(310, 320, 80, 20);
		r2.setFont(new Font("",Font.ITALIC,20));
		add(r2);
		g.add(r2);
		j2=new JLabel("CVV-NO:");
		j2.setBounds(310, 360, 100, 20);
		j2.setFont(new Font("",Font.ITALIC,17));
		add(j2);
		t1=new JTextField();
		t1.setBounds(390, 360, 90, 20);
		add(t1);
		b1=new JButton("Pay Now");
		b1.setBounds(310, 400, 170, 37);
		b1.setFont(new Font("",Font.ITALIC,20));
		add(b1);
		b.addActionListener(this);
		b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String payment=null;
		if(r1.isSelected())
		{
			payment="GPAY";
		}else if(r2.isSelected())
		{
			payment="Card";
		}
		String f=t.getText();
		String l=t1.getText();
		try
		{
		if(e.getSource().equals(b))
		{
			String s=LoginPage.check();
			String qry="Select cust_id from customer_registration where cust_id="+s;
			Statement st=co.createStatement();
			rs=st.executeQuery(qry);
			
			 if(rs.next())
			 {
				 String c=rs.getString("cust_id");
				 String query="insert into mode_of_transaction(cust_id,Payment_Method)values(?,?)";
			     ps=co.prepareStatement(query);
			     ps.setString(1,c);
			     ps.setString(2,payment);
			     ps.executeUpdate();
			     JOptionPane.showMessageDialog(b,"PAYMENT SUCCESSFULL");
			 }
			 try
				{
					if(f.endsWith("@oksbi")||f.endsWith("@okaxis")||f.endsWith("okicic"))
					{}else {
						throw new WrongUpi("upi is invalid please check the upi-id");
					}
				}catch(WrongUpi e1) {System.out.println(e1.getMessage());}
		}
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{	
		if(e.getSource().equals(b1))
		{
			
			String s=LoginPage.check();
			String qry="Select cust_id from customer_registration where cust_id="+s;
			Statement st=co.createStatement();
			rs=st.executeQuery(qry);
		 	if(rs.next())
			 {
				 String c=rs.getString("cust_id");
				 String query="insert into mode_of_transaction(cust_id,Payment_Method)values(?,?)";
			     ps=co.prepareStatement(query);
			     ps.setString(1,c);
			     ps.setString(2,payment);
			     ps.executeUpdate();
			     JOptionPane.showMessageDialog(b1,"PAYMENT SUCCESSFULL");
			 }
		 	try
			{
				if(l.length()<4) {}else {
					throw new incorrectLength("The length of the CVV is atleast 3");
				}
			}catch(incorrectLength e1) {
				System.out.println(e1.getMessage());
			}
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		try {
			Statement s =co.createStatement();
			ResultSet r =s.executeQuery("select * from mode_of_transaction");
			while(r.next())
			{
				System.out.println(r.getString(1)+" "+r.getString(2));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updateAnddelete c = new updateAnddelete();
		c.Cal();
		/*String up="update mode_of_transaction set Payment_Method='GPAY' where cust_id=202";
		try {
			Statement st =co.createStatement();
			st.executeUpdate(up);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String delete="delete from mode_of_transaction where cust_id=7";
		try {
			Statement t =co.createStatement();
			t.executeUpdate(delete);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}

}
