package com.kce.util;

import java.sql.SQLException;

import com.kce.service.Main;

public class UserException extends Exception{
public UserException(String s) throws Exception 
{
	System.out.println("********************"+s+"********************");
	try {
		Main.main(null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
