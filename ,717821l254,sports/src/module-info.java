package com.kce.sports.bean; 
class Coach extends Player 
{ 
public int coach_id; 
public String coach_name; 
public int coach_mobno; 
public int year_of_experience; 
Trainer(int coach_id, String coach_name,int coach_mobno, int 
year_of_experience) 
{ 
this.coach_id=coach_id; 
this.coach_name=coach_name; 
this.coach_mobno=coach_mobno; 
this.year_of_experience=year_of_experience; 
} 
public int getCoach_id() 
{ 
return coach_id; 
} 
public String getCoach_name() 
{ 
return coach_name; 
} 
public int getCoach_mobno() 
{ 
return coach_mobno; 
} 
public int getYear_of_experience() 
{ 
return year_of_experience 
} 
} 
Class Person extends Coach 
{ 
public int person_id; 
public String person_name; 
public int person_mobno; 
public String person_Email; 
public String date_of_join; 
public String person_training_time; 
Member(int person_id, String person_name, int person_mobno, String person_Email, 
String date_of_join, String person_training_time,int coach_id) 
 
{ 
this.person_id=person_id; 
this.person_name=person_name; 
this.person_mobno=person_mobno; 
this.person_Email=person_Email; 
this.date_of_join=date_of_join; 
this.person_training_time=person_training_time; 
super(coach_id); 
} 
public int getPerson_id() 
{ 
return person_id; 
} 
public String getPerson_name() 
{ 
return person_name; 
} 
public int getPerson_mobno() 
{ 
return person_mobno; 
} 
public String getPerson_Email() 
{ 
return person_Email; 
} 
public String getDate_of_join() 
{ 
return date_of_join; 
} 
public String getPerson_training_time() 
{ 
return person_training_time; 
} 
public int getCoach_id() 
{ 
return coach_id; 
} 
} 
package com.kce.coach.util; 
import java.sql.*; 
import java.kce.sports.bean; 
 
class SportsCoach 
{ 
Coach coach=null; 
 
String driverName="com.mysql.jdbc.Driver"; 
String url="jdbc:mysql://localhost:3306/mysql"; 
String userName="root"; 
String password="root"; 
class.forName(driverName).newInstance(); //linking and loading the driver 
connection=DriverManager.getConnection(url,username,password); //establish 
connection 
public Coach createtable() 
{ 
String sql1="create table Coach(coach_id integer,coach_name 
varchar(20),coach_mobno Integer,year_of_experience integer)"; 
PreparedStatement ps1=null; 
try{ 
ps1=connection.prepareStatement(sql1); //prepare query1 
boolean val1=ps1.execute(); //call exectute 
to perforn operation 
System.out.println("table created"+val1); 
} 
catch(Exception e) 
{ 
e.printStackTrace(); 
} 
finally{ 
if(ps1!=null) 
ps1.close(); 
if(connection!=null) 
connection.close(); 
}catch(SQLException | EmptyException e) 
{ 
e.printStackTrace(); 
} 
} 
 
public Coach insertintotable() 
{ 
String sql2="insert into Coach values(?,?,?,?)"; 
 
PreparedStatement ps2=null; 
 
try{ 
ps2=connection.prepareStatement(sql2); 
ps2.setInt(1,coach.getCoach_id()); 
ps2.setString(2,coach.getCoach_name(); 
ps2.setInt(3,coach.getCoach_mobno()); 
ps2.setInt(4,coach.getYear_of_experience()); 
ps2.exectute(); 
} 
catch(Exception e) 
{ 
e.printStackTrace(); 
} 
finally{ 
if(ps2!=null) 
ps2.close(); 
if(connection!=null) 
connection.close(); 
}catch(SQLException | EmptyException e) 
{ 
e.printStackTrace(); 
} 
} 
 
public Coach deletecolumn(int coach_id) 
{ 
String sql3="delete fom Coach where coach_id=?"; 
PreparedStatement ps3=null; 
ps3=connection.preparedStatement(sql13); 
ps.setInt(1,trainer_id); 
ps3.execute(); 
} 
 
public Coach retrivetable(int coach_id) 
{ 
String sql4="select * from Coach where coach_id=?"; 
preparedStatement ps4=null; 
ps4=connection.prepareStatement(sql4); 
ps4.setInt(1,coach_id); 
ResultSet rs=ps.executeQuery(); 
 
while(rs.next()) 
{ 
int coach_id=rs.getInt(1); 
String coach_name=rs.getString(2); 
Int coach_mobno=rs.getInt(3); 
int year_of_experience=rs.getInt(4); 
 
System.out.println("coach_id \t coach_name \t coach_mobno \t

Thakshitha KCE, [6/16/2023 10:11 PM]
year_of_experience); 
System.out.println(coach.getCoach_id+"\t" +coach.getCoach_name+ "\t" 
+coach.getCoach_mobno+ "\t" +coach.getYear_of_experience); 
} 
} 
} 
 
package com.kce.person.util; 
import java.sql.*; 
import java.kce.sports.bean; 
class Sports Person 
{ 
Person person=null; 
String driverName="com.mysql.jdbc.Driver"; 
String url="jdbc:mysql://localhost:3306/mysql"; 
String userName="root"; 
String password="root"; 
class.forName(driverName).newInstance(); //linking and loading the driver 
connection=DriverManager.getConnection(url,username,password); //establish 
connection 
public Person createtable() 
{ 
String sql1="create table Person(person_id integer,person_name 
varchar(20),person_mobno integer,person_Email varchar(20),date_of_join 
varchar(10),person_training_time varchar(20),Coach_id integer)"; 
 
PreparedStatement ps1=null; 
try{ 
ps=connection.prepareStatement(sql1); //prepare query 
boolean val=ps1.execute(); //call exectute to 
perforn operation 
System.out.println("table created"+val1); 
} 
catch(Exception e) 
{ 
e.printStackTrace(); 
} 
finally{ 
if(ps1!=null) 
ps1.close(); 
if(connection!=null) 
connection.close(); 
}catch(SQLException | EmptyException e) 
{ 
e.printStackTrace(); 
} 
} 
 
public Person insertintotable() 
{ 
String sql2="insert into Person values(?,?,?,?,?,?,?)"; 
PreparedStatement ps2=null; 
try{ 
ps2=connection.prepareStatement(sql2); 
ps2.setInt(1,person.getPerson_id()); 
ps2.setString(2,person.getPerson_name()) 
ps2.setInt(3,person.getPerson_mobno()); 
ps2.setString(4,person.getPerson_Email()); 
ps2.setString(5,person.getDate_of_join()); 
ps2.setString(6,person.getPerson_training_time()); 
ps2.setInt(7,person.getCoach_id()); 
ps2.exectute(); 
} 
catch(Exception e) 
{ 
e.printStackTrace(); 
} 
finally{ 
if(ps2!=null) 
 
ps2.close(); 
if(connection!=null) 
connection.close(); 
}catch(SQLException | EmptyException e) 
{ 
e.printStackTrace(); 
} 
} 
 
public Person deletecolumn(int person_id) 
{ 
String sql3="delete fom Person where person_id=?"; 
PreparedStatement ps3=null; 
ps3=connection.preparedStatement(sql13); 
ps.setInt(1,member_id); 
ps3.execute(); 
} 
 
public Person retrivetable(int person_id) 
{ 
String sql4="select * from Person where person_id=?"; 
preparedStatement ps4=null; 
ps4=connection.prepareStatement(sql4); 
ps4.setInt(1,person_id); 
ResultSet rs=ps.executeQuery(); 
while(rs.next()) 
{ 
int person_id=rs.getInt(1); 
String person_name=rs.getString(2); 
Int person_mobno=rs.getInt(3); 
String person_Email=rs.getString(4); 
String date_of_join=rs.getString(5); 
String person_training_time=rs.getString(6); 
int Coach_id=rs.getInt(7); 
System.out.println("person_id \t person_name \t person_mobno \t person_Email \t date_of_join \t person_training_time \t coach_id)"; 
 
System.out.println(person.getPerson_id+ "\t" +person.getPerson_name+ "\t" 
+person.getPerson_mobno+ "\t" +person.getPerson_Email+ "\t" +person.getDate_of_join+ "\t" +person.getPerson_training_time+ "\t" +peerson.getCoach_id); 
} 
} 
 
} 
 
import java.util.*; 
import com.kce.coach.util; 
import com.kce.person.util; 
class SportsCenter 
{ 
public static void main(String [] args) 
{ 
Scanner sc=new Scanner(System.in); 
System.out.println(1.Coach\n2.Person); 
System.out.println("ENTER YOUR CHOICE:"); 
int choice=sc.nextInt(); 
switch(choice) 
{ 
case 1: 
SportsCoach scoach=new SportsCoach(); 
Coach coach=scoach.createtable(); 
scoach.insertintotable(); 
int del_id=sc.nextInt(); 
scoach.deletecolumn(del_id); 
int retrive_id=sc.nextInt(); 
scoach.createtable(retrive_id); 
break; 
case 2: 
SportsPerson sperson=new SportsPerson(); 
Person person=sperson.createtable(); 
sperson.insertintotable(); 
int del_id=sc.nextInt(); 
sperson.deletecolumn(del_id); 
int retrive_id=sc.nextInt(); 
sperson.createtable(retrive_id); 
break; 
default: 
System.out.println("Invalid choice"); 
}
}
}