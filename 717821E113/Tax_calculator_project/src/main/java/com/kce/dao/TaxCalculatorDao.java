package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.bean.TaxCalculator;
import com.kce.util.DButil;

public class TaxCalculatorDao {
	public static void insertData(TaxCalculator tc) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into investments (username,assessment_year,tax_payer,gender,residential_status,total_income) values(?, ? , ? , ? , ?, ? )");
			stmt.setString(1, tc.getUsername());
			stmt.setString(2, tc.getAssessmentyear());
			stmt.setString(3, tc.getTaxpayer());
			stmt.setString(4, tc.getMfs());
			stmt.setString(5, tc.getResidential_status());
			stmt.setString(6, tc.getTotal_income());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
