package com.kce.service;

import com.kce.bean.choiceList;
import com.kce.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class LoginPage extends JFrame implements ActionListener{
	JLabel l,l2,l3,l4,l5;
	JTextField f;
	JPasswordField p;
	JButton b1,b2,b3;
	JPanel j;
	Connection co;
	ResultSet rs=null;
	PreparedStatement ps=null;
	static String str;
	LoginPage()
	{
		co=DBUtil.getConnection();
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
		l3= new JLabel("LOGIN");
		l3.setBounds(420,0,250,200);
		l3.setFont(new Font("serif",Font.BOLD,34));
		add(l3);
		l= new JLabel("CUSTOMER ID");
		l.setBounds(350,70,200,200);
		l.setFont(new Font("serif",Font.BOLD,24));
		add(l);
		f = new JTextField();
		f.setBounds(350,190,250,30);
		f.setFont(new Font("serif",Font.ITALIC,20));
		add(f);
		l2=new JLabel("PASSWORD");
		l2.setBounds(350,140,200,200);
		add(l2);
		l2.setFont(new Font("serif",Font.BOLD,24));
		p= new JPasswordField();
		p.setBounds(350,260,250,30);
		p.setFont(new Font("serif",Font.BOLD,20));
		add(p);
		b1 = new JButton("LOGIN");
		b1.setBounds(350,310,250,40);
		b1.setFont(new Font("serif",Font.BOLD,20));
		add(b1);
		l4= new JLabel("DON'T HAVE AN ACCOUNT REGISTER NOW?");
		l4.setBounds(280,330,500,180);
		l4.setFont(new Font("",Font.PLAIN,18));
		add(l4);
		b3=new JButton("REGISTER");
		b3.setBounds(350,450,250,40);
		b3.setFont(new Font("serif",Font.BOLD,20));
	    add(b3);
		b1.addActionListener(this);
		b3.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String a=f.getText();
		String b=p.getText(); 
		//LoginPage p1 = new LoginPage();
		str=a;
		
		if(e.getSource().equals(b1))
		{
			
			try
			{
				String query="select cust_id,password from customer_registration where cust_id="+a;
				Statement st=co.createStatement();
				rs=st.executeQuery(query);
				if(rs.next())
				{
					String c=rs.getString("cust_id");
					String d=rs.getString("password");
					if(a.equals(c)&&b.equals(d))
					{
						JOptionPane.showMessageDialog(b1, "correct");
						choiceList l=new choiceList();
						f.setText("");
						p.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(b1, "Incorrect");
					}
				}
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			//this.add(new choiceList());
		}
		if(e.getSource()==b2)
		{ 
			f.setText("");
			p.setText("");
		}
		else if(e.getSource().equals(b3))
		{
			this.add(new RegisterPage());
		}
		
	}
	public static String check()
	{
		return str;
	}
}
