<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete Table Action</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f6f8fa;
	text-align: center;
	padding-top: 100px;
}

h1 {
	color: #24292e;
	font-size: 36px;
}

.container {
	margin-top: 40px;
}

.message {
	font-size: 18px;
	margin-bottom: 10px;
}

.back-link {
	font-size: 16px;
	color: #0366d6;
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>Delete Table Action</h1>
	<div class="container">
		<%
            String message = "";
            String url = "jdbc:mysql://localhost:3306/taxmanagement";
            String username = "root";
            String password = "8066408066";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                String investmentTable = "TRUNCATE TABLE investments;";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(investmentTable);
                message = "Table records deleted successfully!";
            } catch (ClassNotFoundException | SQLException e) {
                message = "Error creating table: " + e.getMessage();
                e.printStackTrace();
            } 
        %>

		<p class="message"><%= message %></p>
		<a href="adminoptions.html" class="back-link">Go Back</a>
	</div>
</body>
</html>