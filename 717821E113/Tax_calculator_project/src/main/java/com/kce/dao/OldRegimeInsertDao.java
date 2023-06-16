package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.bean.OldRegimeTaxCalculator;
import com.kce.util.DButil;

public class OldRegimeInsertDao {
	public static void insertOldRegime(OldRegimeTaxCalculator tc) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("update investments set health_education_cess_old=?,total_liability_old=?,tax_liability_old_regime=? where username=? and total_income=?");
			stmt.setDouble(1, tc.getOld_tax_regime()*0.04);
			stmt.setDouble(2, (tc.getOld_tax_regime()*0.04)+tc.getOld_tax_regime());
			stmt.setDouble(3,tc.getOld_tax_regime());
			stmt.setString(4,tc.getUsername());
			stmt.setString(5,tc.getTotal_income());
			stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
