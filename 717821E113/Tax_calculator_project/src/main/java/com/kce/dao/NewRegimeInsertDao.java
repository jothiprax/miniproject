package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.bean.NewRegimeTaxCalculator;

import com.kce.util.DButil;

public class NewRegimeInsertDao {
	public static void insertNewRegime(NewRegimeTaxCalculator tc) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("update investments set health_education_cess_new=?,total_liability_new=?,tax_liability_new_regime=? where username=? and total_income=?");
			stmt.setDouble(1, tc.getNew_tax_regime()*0.04);
			stmt.setDouble(2, (tc.getNew_tax_regime()*0.04)+tc.getNew_tax_regime());
			stmt.setDouble(3,tc.getNew_tax_regime());
			stmt.setString(4,tc.getUsername());
			stmt.setString(5,tc.getTotal_income());
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
