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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.kce.service.LoginPage;
import com.kce.util.DBUtil;

public class nonVegetarian extends JFrame implements ActionListener{
	JLabel l1,foods,d1,quan,food1,food2,food3,food4,food5,food6,r,r1,r2,r3,r4,r5,r6,
    foods1,d2,quan1,food11,food22,rr,r11,r22,
    foods2,d3,quan2,food111,food222,food333,food444,rrr,r111,r222,r333,r444,ac,dis;
JTextField t1,t2,t3,t4,t5,t6,
     t11,t22,
     t111,t222,t333,t444;
JButton b,b1,pay;
Connection co;
ResultSet rs=null;
PreparedStatement ps=null;
public nonVegetarian()
{
	co=DBUtil.getConnection();
	setSize(1000,1000);
	setVisible(true);
	setLayout(null);
	getContentPane().setBackground(Color.GRAY);
	l1= new JLabel("NON-VEGETARIAN FOODS");
	l1.setBounds(500,15,250,150);
	l1.setFont(new Font("serif",Font.BOLD,23));
	add(l1);
	foods=new JLabel ("**Morning Foods**");
	foods.setBounds(110, 130, 180, 30);
	foods.setFont(new Font("serif",Font.BOLD,19));
	add(foods);
	d1=new JLabel("Dishes");
    d1.setBounds(50, 170, 100, 20);
	d1.setFont(new Font("",Font.BOLD,17));
	add(d1);
	quan=new JLabel("Quantity");
    quan.setBounds(290, 170, 100, 20);
	quan.setFont(new Font("",Font.BOLD,17));
	add(quan);
	food1=new JLabel("-->Dosa");
    food1.setBounds(31, 210, 100, 20);
	food1.setFont(new Font("",Font.BOLD,15));
	add(food1);
	t1=new JTextField();
	t1.setBounds(318, 215, 20, 20);
	add(t1);
	r1=new JLabel("40");
	r1.setBounds(220,215, 20, 20);
	r1.setFont(new Font("",Font.BOLD,13));
	add(r1);
	r=new JLabel("Rupees");
	r.setBounds(195,170, 100, 20);
	r.setFont(new Font("",Font.BOLD,17));
	add(r);
	food2=new JLabel("-->Idly");
    food2.setBounds(31, 260, 100, 20);
	food2.setFont(new Font("",Font.BOLD,15));
	add(food2);
	r2=new JLabel("10");
	r2.setBounds(220,260, 20, 20);
	r2.setFont(new Font("",Font.BOLD,13));
	add(r2);
	t2=new JTextField();
	t2.setBounds(318, 260, 20, 20);
	add(t2);
	food3=new JLabel("-->Chicken-Dosa");
    food3.setBounds(31, 305, 170, 20);
	food3.setFont(new Font("",Font.BOLD,15));
	add(food3);
	t3=new JTextField();
	t3.setBounds(318, 305, 20, 20);
	add(t3);
	r3=new JLabel("80");
	r3.setBounds(220,305, 20, 20);
	r3.setFont(new Font("",Font.BOLD,13));
	add(r3);
	food4=new JLabel("-->Crab-Poori");
    food4.setBounds(31, 360, 170, 20);
	food4.setFont(new Font("",Font.BOLD,15));
	add(food4);
	t4=new JTextField();
	t4.setBounds(318, 360, 20, 20);
	add(t4);
	r4=new JLabel("100");
	r4.setBounds(220,360, 25, 20);
	r4.setFont(new Font("",Font.BOLD,13));
	add(r4);
	food5=new JLabel("-->Mutton-Poori");
    food5.setBounds(31, 405, 170, 20);
	food5.setFont(new Font("",Font.BOLD,15));
	add(food5);
	t5=new JTextField();
	t5.setBounds(318, 405, 20, 20);
	add(t5);
	r5=new JLabel("120");
	r5.setBounds(220,405, 25, 20);
	r5.setFont(new Font("",Font.BOLD,13));
	add(r5);
	food6=new JLabel("-->Prawn-Pulao");
    food6.setBounds(31, 460, 190, 20);
	food6.setFont(new Font("",Font.BOLD,15));
	add(food6);
	t6=new JTextField();
	t6.setBounds(318, 460, 20, 20);
	add(t6);
	r6=new JLabel("110");
	r6.setBounds(220,460, 25, 20);
	r6.setFont(new Font("",Font.BOLD,13));
	add(r6);
	
	
	foods1=new JLabel ("**Lunch Foods**");
	foods1.setBounds(500, 130, 180, 30);
	foods1.setFont(new Font("serif",Font.BOLD,19));
	add(foods1);
	d2=new JLabel("Dishes");
    d2.setBounds(420, 170, 100, 20);
	d2.setFont(new Font("",Font.BOLD,17));
	add(d2);
	quan1=new JLabel("Quantity");
    quan1.setBounds(660, 170, 100, 20);
	quan1.setFont(new Font("",Font.BOLD,17));
	add(quan1);
	rr=new JLabel("Rupees");
	rr.setBounds(565,170, 100, 20);
	rr.setFont(new Font("",Font.BOLD,17));
	add(rr);
	food11=new JLabel("-->Chicken-Briyani");
    food11.setBounds(420, 210, 220, 20);
	food11.setFont(new Font("",Font.BOLD,15));
	add(food11);
	t11=new JTextField();
	t11.setBounds(688, 215, 20, 20);
	add(t11);
	r11=new JLabel("70");
	r11.setBounds(590,215, 20, 20);
	r11.setFont(new Font("",Font.BOLD,13));
	add(r11);
	food22=new JLabel("-->Mutton-Briyani");
    food22.setBounds(420, 260, 220, 20);
	food22.setFont(new Font("",Font.BOLD,15));
	add(food22);
	t22=new JTextField();
	t22.setBounds(688, 260, 20, 20);
	add(t22);
	r22=new JLabel("70");
	r22.setBounds(590,260, 20, 20);
	r22.setFont(new Font("",Font.BOLD,13));
	add(r22);
	
	
	foods2=new JLabel ("**Dinner Foods**");
	foods2.setBounds(915, 130, 180, 30);
	foods2.setFont(new Font("serif",Font.BOLD,19));
	add(foods2);
	d3=new JLabel("Dishes");
    d3.setBounds(850, 170, 100, 20);
	d3.setFont(new Font("",Font.BOLD,17));
	add(d3);
	quan2=new JLabel("Quantity");
    quan2.setBounds(1070, 170, 100, 20);
	quan2.setFont(new Font("",Font.BOLD,17));
	add(quan2);
	rrr=new JLabel("Rupees");
	rrr.setBounds(980,170, 100, 20);
	rrr.setFont(new Font("",Font.BOLD,17));
	add(rrr);
	food111=new JLabel("-->Chapatti-Chckn");
    food111.setBounds(850, 210, 220, 20);
	food111.setFont(new Font("",Font.BOLD,15));
	add(food111);
	t111=new JTextField();
	t111.setBounds(1100, 215, 20, 20);
	add(t111);
	r111=new JLabel("100");
	r111.setBounds(1000,215, 25, 20);
	r111.setFont(new Font("",Font.BOLD,13));
	add(r111);
	food222=new JLabel("-->Chicken-Rice");
    food222.setBounds(850, 260, 200, 20);
	food222.setFont(new Font("",Font.BOLD,15));
	add(food222);
	t222=new JTextField();
	t222.setBounds(1100, 260, 20, 20);
	add(t222);
	r222=new JLabel("90");
	r222.setBounds(1000,260, 20, 20);
	r222.setFont(new Font("",Font.BOLD,13));
	add(r222);
	food333=new JLabel("-->Chicken-Parota");
    food333.setBounds(850, 315, 200, 20);
	food333.setFont(new Font("",Font.BOLD,15));
	add(food333);
	t333=new JTextField();
	t333.setBounds(1100, 315, 20, 20);
	add(t333);
	r333=new JLabel("100");
	r333.setBounds(1000,315, 25, 20);
	r333.setFont(new Font("",Font.BOLD,13));
	add(r333);
	food444=new JLabel("-->Kari-Dosa");
    food444.setBounds(850, 360, 200, 20);
	food444.setFont(new Font("",Font.BOLD,15));
	add(food444);
	t444=new JTextField();
	t444.setBounds(1100, 360, 20, 20);
	add(t444);
	r444=new JLabel("80");
	r444.setBounds(1000,360, 20, 20);
	r444.setFont(new Font("",Font.BOLD,13));
	add(r444);
	b=new JButton("<Back");
	b.setBounds(30,50,100,20 );
	b.setFont(new Font("",Font.BOLD,20));
	add(b);
	b.addActionListener(this);
	b1=new JButton("Total Amount:");
	b1.setBounds(40, 580, 180, 25);
	b1.setFont(new Font("",Font.BOLD,20));
	add(b1);
	ac=new JLabel();
	ac.setFont(new Font("",Font.BOLD,20));
	ac.setBounds(250, 580, 50, 20);
	add(ac);
	dis=new JLabel("[Note: If you don't want any foods here. Please make it as 0 as quantity!]");
	dis.setFont(new Font("",Font.BOLD,18));
	dis.setBounds(500, 580, 680, 20);
	add(dis);
	b1.addActionListener(this);
	pay=new JButton("Go For Payment!");
	pay.setFont(new Font("",Font.BOLD,20));
	pay.setBounds(1020, 50, 200, 25);
	add(pay);
	pay.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(b))
	{
		this.add(new choiceList());
	}
	if(e.getSource().equals(b1))
	{
		//MORNING_ROUTINE
		String dosa=t1.getText();//String dosa1=(dosa=="")?"0":dosa;
		int dos=(Integer.parseInt(dosa));//int dos1=(dos>0)?dos:0;
		String idly=t2.getText();//String id=(idly=="")?"0":idly;
		int it=(Integer.parseInt(idly));//int it1=(it>0)?it:0;
		String mal=t3.getText();
		int mald=(Integer.parseInt(mal));
		String puri=t4.getText();
		int p=(Integer.parseInt(puri));
		String cp=t5.getText();
		int ch=(Integer.parseInt(cp));
		String pulao=t6.getText();
		int pl=(Integer.parseInt(pulao));
		int morng_tot=((dos*40)+(it*10)+(mald*80)+(p*100)+(ch*120)+(pl*110));
		String s =String.valueOf(morng_tot);
		
		//LUNCH ROUTINE
		String r=t11.getText();
		int ri=(Integer.parseInt(r)*70);
		String v=t22.getText();
		int veg=(Integer.parseInt(v)*70);
		int luch_tot=ri+veg+morng_tot;
		String s1=String.valueOf(luch_tot);
		
		//DINNER ROUNTINE
		String chap=t111.getText();int chapp=(Integer.parseInt(chap)*100);
		String mu=t222.getText();int bri=(Integer.parseInt(mu)*90);
		String pa=t333.getText();int ro=(Integer.parseInt(pa)*100);
		String ds=t444.getText();int sa=(Integer.parseInt(ds)*80);
		int tot=luch_tot+chapp+bri+ro+sa;String s11=String.valueOf(tot);
		ac.setText(s11);
	}
	try {
		if(e.getSource().equals(pay))
		{
			String dosa=t1.getText();String idly=t2.getText();String mal=t3.getText();
			String puri=t4.getText();String cp=t5.getText();String pulao=t6.getText();
			String r=t11.getText();String v=t22.getText();String chap=t111.getText();
			String mu=t222.getText();String pa=t333.getText();String ds=t444.getText();String t=ac.getText();
			String s=LoginPage.check();
			String qry="Select cust_id from customer_registration where cust_id="+s;
		    Statement st=co.createStatement();
		    rs=st.executeQuery(qry);
		    if(rs.next())
		    {
		    	String c=rs.getString("cust_id");
		    	String query="insert into nonVegetarian(cust_id,Dosa,Idly,Chicken_Dosa,Crab_Poori,Mutton_Poori,Prawn_Pulao,Chicken_Briyani,Mutton_Briyani,Chappati_Chicken,Chicken_Rice,Chicken_Parotta,Kari_Dosa,Total_Amount)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    	ps=co.prepareStatement(query);
				ps.setString(1,c);
				ps.setString(2,dosa);
				ps.setString(3,idly);
				ps.setString(4,mal);
				ps.setString(5,puri);
				ps.setString(6,cp);
				ps.setString(7,pulao);
				ps.setString(8,r);
				ps.setString(9,v);
				ps.setString(10,chap);
				ps.setString(11,mu);
				ps.setString(12,pa);
				ps.setString(13,ds);
				ps.setString(14,t);
				ps.executeUpdate();
				payment p =new payment();
				//JOptionPane.showMessageDialog(pay,"Thanks For Feedback");
		    }//this.add(new payment());
		} 
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
}
