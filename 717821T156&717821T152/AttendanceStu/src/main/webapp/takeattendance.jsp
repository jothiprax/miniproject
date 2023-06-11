<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take Attendance</title>
<%@page import="java.sql.*"%>
<%@page import="com.kce.vignesh.util.*"%>
</head>
<body>
	<h1>Mark the Attendance For the Students</h1>
	<%
	try {
		Connection con = DBUtil.getDBConnection();
		String query = "select studId,name from student";
		Statement st = con.createStatement();
		Statement state = con.createStatement();
		ResultSet sturs=state.executeQuery(query);
		ResultSet subrs=st.executeQuery("select name from subject");
	%>
	<div class="takeattendance" align="center">
		<form id="attendance" action="MarkAttendanceServlet" method="post">
			<select>
				<option >--select--</option>
				<%
				while (subrs.next()) {
					String fname = subrs.getString(1);
				%>
				<option value="<%=fname%>"><%=fname%></option>
				<%
				} 
				%>
			</select>
			<table border=1 style="text-align: center">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Present/Absent</th>
					</tr>
				</thead>
				<tbody>
					<%
					
					while (sturs.next()) {
					%>
					<tr>
						<td><%=sturs.getString(1)%></td>
						<td><%=sturs.getString(2)%></td>
						<td><input type=checkbox name=pastatus value=<%=sturs.getString(2)%>></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<input type=submit>
		</form>
	</div>
	<br>
	<%
	} catch (Exception e) {
	out.print(e.getMessage());
	%><br>
	<%
	}
	%>
</body>
</html>