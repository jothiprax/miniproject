<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of All the Students</title>
<%@page import="java.sql.*"%>
<%@page import="com.kce.vignesh.util.*"%>
</head>
<body>
<h1>The List of Students : </h1>
	<%
	try{
		Connection con=DBUtil.getDBConnection();
		String query="select * from student";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
	%>
	<div class= "viewstudents" align="center">
		<table border=1 style="text-align: center">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Department</th>
				</tr>
			</thead>
			<tbody>
				<%while(rs.next()){ %>
					<tr>
						<td><%=rs.getString(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
					</tr>
				<%}%>
			</tbody>
		</table>
	</div>
	<br>
	<%}
    catch(Exception e){
        out.print(e.getMessage());%><br>
	<%
    }
    %>
</body>
</html>