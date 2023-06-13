<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Login.css"/>
<title>Login</title>
</head>
<body>
	<div class="LogForm" align="center">
		<form id="Login" action="LoginServlet" method="post">
			<table>
			
				<tr>
					<td>Enter UserName :</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Enter Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><label for="usertype"> Select UserType : </label></td>
					<td><select id="usertype" name="usertype" form="Login">
							<option >--Select--</option>
							<option value="staff">Staff</option>
							<option value="student">Student</option>
							<option value="admin">Administrator</option>
					</select></td>
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit" value="Login"></td>					
				</tr>
			
			</table>
		</form>

	</div>
</body>
</html>