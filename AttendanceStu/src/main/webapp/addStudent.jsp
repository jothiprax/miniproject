<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
<div class="AddStudent" align="center">
		<form id="AddStud" action="StudentServlet" method="post">
			<table>
				<tr>
					<td>Enter Student username :</td>
					<td><input type="text" name="studusername"></td>
				</tr>
				<tr>
					<td>Enter Student password :</td>
					<td><input type="text" name="studpassword"></td>
				</tr>
				<tr>
					<td>Enter Student ID :</td>
					<td><input type="text" name="studID"></td>
				</tr>
				<tr>
					<td>Enter Student Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Enter Department Name : </td>
					<td><input type="text" name="deptID"></td>
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit" value="Add"></td>					
				</tr>
			
			</table>
		</form>

	</div>

</body>
</html>