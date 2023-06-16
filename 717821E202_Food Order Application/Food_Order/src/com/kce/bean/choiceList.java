package com.kce.bean;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import com.kce.bean.*;
import com.kce.util.*;
public class choiceList extends JFrame implements ActionListener{
	JLabel text;
	JButton b1,b2,b3;
	public choiceList()
	{
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
		text=new JLabel("Which side are you looking for?");
		text.setBounds(330,180,480,60);
		text.setFont(new Font("",Font.BOLD,24));
		add(text);
		b1=new JButton("Vegetarian");
		b1.setBounds(426, 246, 170, 30);
		b1.setFont(new Font("",Font.ITALIC,19));
		add(b1);
		b2=new JButton("Non-Vegetarian");
		b2.setFont(new Font("",Font.ITALIC,19));
		b2.setBounds(426, 290, 170, 30);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b1))
		{
			this.add(new Vegetarain());
		}
		if(e.getSource().equals(b2))
		{
			this.add(new nonVegetarian());
		}
		
	}
}
