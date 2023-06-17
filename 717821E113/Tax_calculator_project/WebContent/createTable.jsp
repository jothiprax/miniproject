<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Table Action</title>
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
	<h1>Create Table Action</h1>
	<div class="container">
		<%
            String message = "";
            String url = "jdbc:mysql://localhost:3306/taxmanagement";
            String username = "root";
            String password = "8066408066";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                String investmentTable = "CREATE TABLE IF NOT EXISTS investments (username varchar(45) NOT NULL, assessment_year varchar(45) NOT NULL, tax_payer varchar(45) NOT NULL, gender varchar(45) NOT NULL, residential_status varchar(45) NOT NULL, total_income varchar(45) NOT NULL, tax_liability_old_regime double DEFAULT NULL, tax_liability_new_regime double DEFAULT NULL, health_education_cess_old double DEFAULT NULL, total_liability_old double DEFAULT NULL, health_education_cess_new double DEFAULT NULL, total_liability_new double DEFAULT NULL, id int NOT NULL AUTO_INCREMENT, UNIQUE KEY id_UNIQUE (id)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
                String loginTable="CREATE TABLE IF NOT EXISTS login (username varchar(50) NOT NULL, email varchar(50) NOT NULL, password varchar(45) NOT NULL, PRIMARY KEY (username), UNIQUE KEY username_UNIQUE (username), UNIQUE KEY email_UNIQUE (email)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(investmentTable);
                stmt.executeUpdate(loginTable);
                message = "Table created successfully!";
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
