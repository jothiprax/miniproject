package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Emp;

public class Empdao {
	private Connection conn;

	public Empdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean dataInsert(Emp emp) {
		boolean f = false;

		try {

			PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getAddress());
			ps.setInt(4, emp.getSalary());

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editData(Emp em) {
		boolean f = false;

		try {

			PreparedStatement ps = conn.prepareStatement("update employees set name=?,address=? where id=?");
			ps.setString(1, em.getName());
			ps.setString(2, em.getAddress());
			ps.setInt(3, em.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteData(int id) {
		boolean f = false;

		try {

			PreparedStatement ps = conn.prepareStatement("delete from employees where id=?");
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public Emp getInfo(int id) {
		Emp obj = null;

		try {

			PreparedStatement ps = conn.prepareStatement("select * from employees where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				obj = new Emp();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setAddress(rs.getString(4));
				obj.setSalary(rs.getInt(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	public List<Emp> getAllData() {
		List<Emp> list = new ArrayList<Emp>();
		Emp em = null;

		try {

			PreparedStatement ps = conn.prepareStatement("select * from employees");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				em = new Emp();
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setAddress(rs.getString(3));
				em.setSalary(rs.getInt(4));
				list.add(em);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
