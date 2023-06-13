<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Administrator</title>
</head>
<body>
	<h1>Welcome Administrator</h1>
	<div class="Admin" align="center">
		<form id="Admin" action="AdminServlet" method="post">
			<input type="submit" value="Add Student" name="Act">
			<input type="submit" value="Add Staff" name="Act">
			<input type="submit" value="Add Subject" name="Act">
		</form>

	</div>
</body>
</html>