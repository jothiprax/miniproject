<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Staff</title>
</head>
<div class="AddStaff" align="center">
		<form id="AddStaff" action="StaffServlet" method="post">
			<table>
				<tr>
					<td>Enter Staff username :</td>
					<td><input type="text" name="staffusername"></td>
				</tr>
				<tr>
					<td>Enter Staff password :</td>
					<td><input type="text" name="staffpassword"></td>
				</tr>
				<tr>
					<td>Enter Staff ID :</td>
					<td><input type="text" name="staffID"></td>
				</tr>
				<tr>
					<td>Enter Staff Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Enter Staff Domain (Subject) : </td>
					<td><input type="text" name="staffdomain"></td>
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit" value="Add"></td>					
				</tr>
			
			</table>
		</form>

	</div>

</body>
</html>