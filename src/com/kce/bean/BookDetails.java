package com.kce.bean;
import com.kce.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BookDetails {
public void GeneralKnowledgeBooks()throws SQLException,ClassNotFoundException{
	Connection con=DButil.getConnections();
	PreparedStatement psmt=con.prepareStatement("insert into GeneralKnowledgeBooks values(?,?,?,?)");
	psmt.setInt(1,1);
	psmt.setString(2,"Midnight's Children");
	psmt.setString(3,"Salman Rushdie");
	psmt.setInt(4, 5);
	psmt.executeUpdate();
	psmt.setInt(1,2);
	psmt.setString(2,"The White Tiger");
	psmt.setString(3,"Aravind Adiga");
	psmt.setInt(4, 3);
	psmt.executeUpdate();
	psmt.setInt(1,3);
	psmt.setString(2,"The God of Small Things");
	psmt.setString(3,"Arundhati Roy");
	psmt.setInt(4, 6);
	psmt.executeUpdate();
	psmt.setInt(1,4);
	psmt.setString(2,"The Discovery of India");
	psmt.setString(3,"Jawaharlal Nehru");
	psmt.setInt(4, 2);
	psmt.executeUpdate();
	psmt.setInt(1,5);
	psmt.setString(2,"The Land of Vedas");
	psmt.setString(3,"R. Muthukumar");
	psmt.setInt(4, 4);
	psmt.executeUpdate();
}
public void ProgrammingBooks()throws SQLException,ClassNotFoundException{
	Connection con=DButil.getConnections();
	PreparedStatement psmt=con.prepareStatement("insert into ProgrammingBooks values(?,?,?,?)");
	psmt.setInt(1,6);
	psmt.setString(2,"C Programming");
	psmt.setString(3,"Dennis Ritchie");
	psmt.setInt(4, 2);
	psmt.executeUpdate();
	psmt.setInt(1,7);
	psmt.setString(2,"Java Programming");
	psmt.setString(3,"James Gosling");
	psmt.setInt(4, 5);
	psmt.executeUpdate();
	psmt.setInt(1,8);
	psmt.setString(2,"phython");
	psmt.setString(3,"Guido van Rossum");
	psmt.setInt(4, 4);
	psmt.executeUpdate();
	psmt.setInt(1,9);
	psmt.setString(2,"Java script");
	psmt.setString(3,"Brendan Eich ");
	psmt.setInt(4, 6);
	psmt.executeUpdate();
	psmt.setInt(1,10);
	psmt.setString(2,"HTML");
	psmt.setString(3,"Tim Berners-Lee");
	psmt.setInt(4, 3);
	psmt.executeUpdate();
}
public void ExamPreparationBooks()throws SQLException,ClassNotFoundException{
	Connection con=DButil.getConnections();
	PreparedStatement psmt=con.prepareStatement("insert into ExamPreparationBooks values(?,?,?,?)");
	psmt.setInt(1,11);
	psmt.setString(2,"Manual for TNPSC Examinations");
	psmt.setString(3,"M.Karthikeyan");
	psmt.setInt(4, 4);
	psmt.executeUpdate();
	psmt.setInt(1,12);
	psmt.setString(2,"Quantitative Aptitude");
	psmt.setString(3,"R.S Agarwal");
	psmt.setInt(4, 2);
	psmt.executeUpdate();
	psmt.setInt(1,13);
	psmt.setString(2,"Indian Polity");
	psmt.setString(3,"M.Laxmikanth");
	psmt.setInt(4, 5);
	psmt.executeUpdate();
	psmt.setInt(1,14);
	psmt.setString(2," Indian Economy");
	psmt.setString(3,"Nitin Singhania");
	psmt.setInt(4, 3);
	psmt.executeUpdate();
}
public void ComicBooks()throws SQLException,ClassNotFoundException{
	Connection con=DButil.getConnections();
	PreparedStatement psmt=con.prepareStatement("insert into ComicBooks values(?,?,?,?)");
	psmt.setInt(1,15);
	psmt.setString(2,"Corridor");
	psmt.setString(3,"Sarnath Banerjee");
	psmt.setInt(4, 2);
	psmt.executeUpdate();
	psmt.setInt(1,16);
	psmt.setString(2,"The Village");
	psmt.setString(3,"Sanjay Patel");
	psmt.setInt(4, 1);
	psmt.executeUpdate();
	psmt.setInt(1,17);
	psmt.setString(2,"Kari");
	psmt.setString(3,"Amruta Patil");
	psmt.setInt(4, 4);
	psmt.executeUpdate();
}
//public static void main(String[] args)throws SQLException,ClassNotFoundException{
	//BookDetails bd=new BookDetails();
	//bd.GeneralKnowledgeBooks();
	//bd.ProgrammingBooks();
	//bd.ExamPreparationBooks();
	//bd.ComicBooks();
//}
}