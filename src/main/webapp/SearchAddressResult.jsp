<!--Sebastian Shaimas-->
<!--CS 351, Section 1-->
<!--Assignment 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<style>
table, th, td{
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
  padding: 5px;
}
</style>
</head>
<body>
	<b>Search Results</b><br><br>

	<table class="center">
		<tr>
			<th>First Name</th>
			<th>Surname</th>
			<th>Telephone</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Address</th>
			<th>Post Code</th>
			<th>Town</th>
			<th>Country</th>
		</tr>
		<% out.println(session.getAttribute("resultTable")); %>
	</table>
</body>
</html>