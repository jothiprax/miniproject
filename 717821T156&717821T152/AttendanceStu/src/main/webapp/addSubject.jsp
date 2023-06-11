<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Subject</title>
</head>
<body>
	<div class="AddSubject" align="center">
		<form id="AddSub" action="SubjectServlet" method="post">
			<table>
				<tr>
					<td>Enter Subject ID :</td>
					<td><input type="text" name="subId"></td>
				</tr>
				<tr>
					<td>Enter Subject Name :</td>
					<td><input type="text" name="subname"></td>
				</tr>
				<tr>
					<td>Enter No. Of Hours Required :</td>
					<td><input type="text" name="hoursRequired"></td>
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit" value="Add"></td>	
				</tr>
			
			</table>
		</form>

	</div>
</body>
</html>