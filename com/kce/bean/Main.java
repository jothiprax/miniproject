package com.kce.bean;
import java.util.Scanner;
import com.kce.dao.MusicDataBase;
import com.kce.service.MusicStore;
import com.kce.util.UtilConnection;
public class Main {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter user Choice:");
	String art = sc.nextLine();
	MusicStore m = new MusicStore(art);
	MusicDataBase mb= new MusicDataBase();
	   mb.displayByArtist(m);
try {
	throw new StockUnavilableException("Stock not Available");
}
	catch(StockUnavilableException se){
		System.out.println(se);
	}
}
}

