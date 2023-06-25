package com.kce.dao;

import com.kce.bean.Result;
import com.kce.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ResultDAO {
    public void addResult(Result result) {
        String query = "INSERT INTO results (result_id, student_id, subject_name, marks) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, result.getResultId());
            statement.setInt(2, result.getStudentId());
            statement.setString(3, result.getSubjectName());
            statement.setDouble(4, result.getMarks());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<Result> getResultsByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
