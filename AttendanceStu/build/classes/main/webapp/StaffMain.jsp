<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome
		<%=(request.getSession().getAttribute("username"))%>
	</h1>
	<div class="Admin" align="center">
		<form id="Login" action="StaffActionServlet" method="post">
			<input  type="submit" name="act" value="Take Attendance"></input>
			<input  type="submit" name="act" value="View Students"></input>
			<input type="submit" name="act" value = "View Report"></input>
		</form>
	</div>
</body>
</html>