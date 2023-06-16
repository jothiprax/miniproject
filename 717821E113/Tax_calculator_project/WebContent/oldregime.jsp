<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tax Calculation Report</title>
<%@page import="com.kce.util.*"%>
<%@page import="java.sql.*"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
<style>
body {
	padding: 20px;
}

.container {
	max-width: 100%;
	overflow-x: auto;
}

.table {
	width: 100%;
	white-space: nowrap;
}

.table th, .table td {
	text-align: left;
}

@media ( max-width : 576px) {
	.table-responsive {
		overflow-x: auto;
		-webkit-overflow-scrolling: touch;
		-ms-overflow-style: -ms-autohiding-scrollbar;
	}
}

.print {
	margin: 0;
	position: absolute;
	top: 80%;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

.table-responsive {
	border: none;
	margin-bottom: 0;
	box-shadow: none;
}

.table-responsive .table {
	margin-bottom: 0;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="mt-4">Report - Old Tax Regime</h1>
		<%
		String username = (String) session.getAttribute("username");
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement(
			"SELECT username,assessment_year,tax_payer,gender,residential_status,total_income,tax_liability_old_regime,health_education_cess_old,total_liability_old FROM investments WHERE username = ? order by id DESC LIMIT 1");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
		%>
		<div class="table-responsive mt-4">
			<table class="table table-bordered">
				<tbody>
					<%
					while (rs.next()) {
					%>
					<tr>
						<th>User name</th>
						<td><%=rs.getString(1)%></td>
					</tr>
					<tr>
						<th>Assessment year</th>
						<td><%=rs.getString(2)%></td>
					</tr>
					<tr>
						<th>Tax payer</th>
						<td><%=rs.getString(3)%></td>
					</tr>
					<tr>
						<th>M/F/Senior citizen</th>
						<td><%=rs.getString(4)%></td>
					</tr>
					<tr>
						<th>Residential status</th>
						<td><%=rs.getString(5)%></td>
					</tr>
					<tr>
						<th>Total income</th>
						<td><%=rs.getString(6)%></td>
					</tr>
					<tr>
						<th>Old Tax regime</th>
						<td><%=rs.getDouble(7)%></td>
					</tr>
					<tr>
						<th>Health and education cess</th>
						<td><%=rs.getDouble(8)%></td>
					</tr>
					<tr>
						<th>Total liability</th>
						<td><%=rs.getDouble(9)%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<br>
		<%
		} catch (Exception e) {
		out.print(e.getMessage());
		%><br>
		<%
		}
		%><button onclick="window.print()" class="print">Print</button>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>

