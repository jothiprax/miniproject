<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Student</title>
</head>
<body>
	<h1>
		Welcome
		<%=(request.getSession().getAttribute("username"))%></h1>
	<div class="Admin" align="center">
		<form id="Login" action="viewReport.jsp" method="post">
			<input  type="submit" name="act" value="view Report"></input>
		</form>
	</div>
</body>
</html>