<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Display User Action</title>
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

.table-container {
	display: flex;
	justify-content: center;
}

.table {
	border-collapse: collapse;
	margin-top: 20px;
}

.table th, .table td {
	padding: 10px;
	border: 1px solid #d1d5da;
}

.table th {
	background-color: #f6f8fa;
	font-weight: bold;
}

.table td {
	background-color: #fff;
}
</style>
</head>
<body>
	<h1>Display Users Action</h1>
	<div class="container">
		<%
            String message = "";
            String url = "jdbc:mysql://localhost:3306/taxmanagement";
            String username = "root";
            String password = "8066408066";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                String loginTable = "SELECT * FROM login";
                Statement stmt = con.createStatement();
                ResultSet rs=stmt.executeQuery(loginTable);
                if (rs.next()) {
        %>
		<div class="table-container">
			<table class="table">
				<thead>
					<tr>
						<th>User name</th>
						<th>Email Id</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<% do { %>
					<tr>
						<td><%= rs.getString(1) %></td>
						<td><%= rs.getString(2) %></td>
						<td><%= rs.getString(3).subSequence(1,2) + "*******" %></td>
					</tr>
					<% } while (rs.next()); %>
				</tbody>
			</table>
		</div>
		<%
                message = "User records printed successfully!";
            } else {
                message = "No user records found!";
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            message = "Error retrieving user records: " + e.getMessage();
            e.printStackTrace();
        }
        %>

		<p class="message"><%= message %></p>
		<a href="adminoptions.html" class="back-link">Go Back</a>
	</div>
</body>
</html>
