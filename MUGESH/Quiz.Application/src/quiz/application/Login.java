	package quiz.application;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class Login extends JFrame implements ActionListener{
	 
	    JButton rules, back;
	    JTextField tfname;
	    
	    Login() {
	        getContentPane().setBackground(Color.WHITE);
	        setLayout(null);
	   
	        JLabel lable = new JLabel("");
	        Image img = new ImageIcon(this.getClass().getResource("/login.JPG")).getImage();
	        lable.setIcon(new ImageIcon(img));
	        lable.setBounds(0,0,1000,650);
	        add(lable);
	        
	        JLabel heading = new JLabel("Simple Minds");
	        heading.setBounds(750, 60, 300, 65);
	        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
	        heading.setForeground(new Color(30, 144, 254));
	        add(heading);
	        
	        JLabel name = new JLabel("Enter your name");
	        name.setBounds(810, 150, 300, 20);
	        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
	        name.setForeground(new Color(30, 144, 254));
	        add(name);
	        
	        tfname= new JTextField();
	        tfname.setBounds(735, 200, 300, 25);
	        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        add(tfname);
	        
	        rules = new JButton("Rules");
	        rules.setBounds(735, 270, 120, 25);
	        rules.setBackground(new Color(30, 144, 254));
	        rules.setForeground(Color.WHITE);
	        rules.addActionListener(this);
	        add(rules);
	        
	        back = new JButton("Back");
	        back.setBounds(915, 270, 120, 25);
	        back.setBackground(new Color(30, 144, 254));
	        back.setForeground(Color.WHITE);
	        back.addActionListener(this);
	        add(back);
	        
	        setSize(1200, 500);
	        setLocation(200, 150);
	        setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == rules) {
	        	String name = tfname.getText();
	            setVisible(false);
	           new Rules(name);
	        } else if (ae.getSource() == back) {
	            setVisible(false);
	        }
	    }
	    
	    public static void main(String[] args) {
	        new Login();
	    }
	}

