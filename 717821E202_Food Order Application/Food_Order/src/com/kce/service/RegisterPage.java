package com.kce.service;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.kce.util.DBUtil;
  public class RegisterPage extends JFrame implements ActionListener{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	JComboBox c;
	JTextField j,j1,j2,j3,j4,j5,j6,j7;
	JComboBox a;
	JPasswordField p,p1;
	JButton b,b1;
	Connection co;
	PreparedStatement ps=null;
	public RegisterPage()
	{
		co=DBUtil.getConnection();
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.GRAY);
		l7= new JLabel("REGISTRATION");
		l7.setBounds(420,15,250,150);
		l7.setFont(new Font("serif",Font.BOLD,23));
		add(l7);
		l= new JLabel("FIRST NAME");
		l.setBounds(320,70,250,150);
		l.setFont(new Font("serif",Font.BOLD,20));
		add(l);
		j = new JTextField();
		j.setBounds(550,132,160,24);
		add(j);
		l1= new JLabel("LAST NAME");
		l1.setBounds(320,110,250,150);
		l1.setFont(new Font("serif",Font.BOLD,20));
		add(l1);
		j1 = new JTextField();
		j1.setBounds(550,170,160,24);
		add(j1);
		l2= new JLabel("CUSTOMER ID");
		l2.setBounds(320,150,250,150);
		l2.setFont(new Font("serif",Font.BOLD,20));
		add(l2);
		j2 = new JTextField();
		j2.setBounds(550,210,160,24);
		add(j2);
		l3= new JLabel("EMAIL-ID");
		l3.setBounds(320,190,250,150);
		l3.setFont(new Font("serif",Font.BOLD,20));
		add(l3);
		j3 = new JTextField();
		j3.setBounds(550,250,160,24);
		add(j3);
			    
		l4= new JLabel("PHONE NUMBER");
		l4.setBounds(320,230,250,150);
		l4.setFont(new Font("serif",Font.BOLD,20));
		add(l4);
		j7=new JTextField();
	    j7.setBounds(550, 292, 160, 24);
	    add(j7);

		l5= new JLabel("PASSWORD");
		l5.setBounds(320,270,250,150);
		l5.setFont(new Font("serif",Font.BOLD,20));
		add(l5);
		p= new JPasswordField();
		p.setBounds(550,330,160,24);
		add(p);
		l8= new JLabel("RE-TYPE PASSWORD");
		l8.setBounds(320,310,250,150);
		l8.setFont(new Font("serif",Font.BOLD,20));
		add(l8);
		p1= new JPasswordField();
		p1.setBounds(550,372,160,24);
		add(p1);
		b=new JButton("REGISTER");
		b.setFont(new Font("serif",Font.BOLD,23));
		b.setBounds(335,430,200,47);
	    b.addActionListener(this);
	    add(b);
		b1=new JButton("NEXT");
		b1.setFont(new Font("serif",Font.BOLD,23));
		b1.setBounds(540,430,160,47);
		add(b1);
	    b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String f_name=j.getText();	
        String l_name=j1.getText();
        String cust_id=j2.getText();
        String mail_id=j3.getText();
        String phone_no=j7.getText();
		String pass=p.getText();
	    String repass=p1.getText();
		if(e.getSource().equals(b))
		{
			if(pass.contentEquals(repass))
			{
				String query="insert into customer_registration (first_name,last_name,cust_id,email_id,phone_no,password,retype_pass)values(?,?,?,?,?,?,?)";   
				try
				{
					ps=co.prepareStatement(query);
					ps.setString(1,f_name);
					ps.setString(2,l_name);
					ps.setString(3,cust_id);
					ps.setString(4,mail_id);
					ps.setString(5,phone_no);
					ps.setString(6,pass);
					ps.setString(7,repass);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(b1,"REGISTERED SUCCESSFULLY");
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(b,"Incorrect password");
			}
		}
		try
		{
		PreparedStatement stmt=co.prepareStatement("select * from customer_registration");  
		ResultSet rs=stmt.executeQuery(); 
		while(rs.next())
		{
			System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6)+""+rs.getString(7));
		}
		}catch(Exception e1) {System.out.print(e1);}
		if(e.getSource().equals(b1))
		{
		
			this.add(new LoginPage());
		}
	}
}

