package com.kce.dao;

import com.kce.bean.Course;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO course (course_name, course_code, start_date, end_date) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseCode());
            pstmt.setString(3, course.getStartDate());
            pstmt.setString(4, course.getEndDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE course SET course_name = ?, start_date = ?, end_date = ? WHERE course_code = ?")) {
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getStartDate());
            pstmt.setString(3, course.getEndDate());
            pstmt.setString(4, course.getCourseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(String courseCode) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM course WHERE course_code = ?")) {
            pstmt.setString(1, courseCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getCourseByCode(String courseCode) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM course WHERE course_code = ?")) {
            pstmt.setString(1, courseCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String courseName = rs.getString("course_name");
                    String startDate = rs.getString("start_date");
                    String endDate = rs.getString("end_date");
                    return new Course(courseName, courseCode, startDate, endDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM course")) {
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                String courseCode = rs.getString("course_code");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                Course course = new Course(courseName, courseCode, startDate, endDate);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}

