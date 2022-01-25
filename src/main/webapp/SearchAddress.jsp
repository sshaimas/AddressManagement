<!--Sebastian Shaimas-->
<!--CS 351, Section 1-->
<!--Assignment 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Search</title>
</head>
<body>
	<b>Search the Database</b><br><br>
	<form method="post" action="exSearchAddress.jsp">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>Telephone:</td>
				<td><input type="text" name="telephone"></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Street Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Postal Code:</td>
				<td><input type="text" name="postalnr"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="town"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"></td>
			</tr>
		</table>
		<br><br>
		<Button type="submit" name="search">Search</Button>
	</form>
</body>
</html>