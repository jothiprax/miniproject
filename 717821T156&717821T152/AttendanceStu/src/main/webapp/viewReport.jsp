<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Report</title>
<%@page import="java.sql.*"%>
<%@page import="com.kce.vignesh.util.*"%>
</head>
<body>
<h1>Attendance Report</h1>
	<%
	try{
		Connection con=DBUtil.getDBConnection();
		String query="select * from student";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		Statement stm=con.createStatement();
		ResultSet rsm=stm.executeQuery("select SUM(hoursRequired) from subject");
		int n=0;
		while(rsm.next()){
			n = rsm.getInt(1);
		}
	%>
	<div class= "viewstudents" align="center">
		<table border=1 style="text-align: center">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Total No. Of Hours</th>
					<th>Attendance Percentage %</th>
				</tr>
			</thead>
			<tbody>
				<%while(rs.next()){ %>
					<tr>
						<td><%=rs.getString(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
						<td><%=n %></td>
						<% 
							double k=rs.getInt(4)/(float)n;
							k*=100;
						%>
						<td><%=k %></td>
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