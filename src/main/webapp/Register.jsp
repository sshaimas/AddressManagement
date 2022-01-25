<!--Sebastian Shaimas-->
<!--CS 351, Section 1-->
<!--Assignment 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<b>Registration Form</b><br><br>
	<form method="post" action="exRegister.jsp">
		<table>
			<tr>
				<td id="fn">First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td id="contact1">Telephone:</td>
				<td><input type="text" name="telephone"></td>
			</tr>
			<tr>
				<td id="contact2">Mobile:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td id="contact3">Email:</td>
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
		<Button type="submit" name="register">Register</Button>
	</form>
</body>
<script type="text/javascript">
window.addEventListener("load", function(){
	var fname = '<%= session.getAttribute("fname") %>';
	var sname = '<%= session.getAttribute("sname") %>';
	var telephone = '<%= session.getAttribute("telephone") %>';
	var mobile = '<%= session.getAttribute("mobile") %>';
	var email = '<%= session.getAttribute("email") %>';
	var address = '<%= session.getAttribute("address") %>';
	var postalnr = '<%= session.getAttribute("postalnr") %>';
	var town = '<%= session.getAttribute("town") %>';
	var country = '<%= session.getAttribute("country") %>';
	var failed = '<%= session.getAttribute("failed") %>';
	
	if(fname != "null"){
		document.getElementsByName("fname")[0].value = fname;
	}
	if(sname != "null"){
		document.getElementsByName("sname")[0].value = sname;
	}
	if(telephone != "null"){
		document.getElementsByName("telephone")[0].value = telephone;
	}
	if(mobile != "null"){
		document.getElementsByName("mobile")[0].value = mobile;
	}
	if(email != "null"){
		document.getElementsByName("email")[0].value = email;
	}
	if(address != "null"){
		document.getElementsByName("address")[0].value = address;
	}
	if(postalnr != "null"){
		document.getElementsByName("postalnr")[0].value = postalnr;
	}
	if(town != "null"){
		document.getElementsByName("town")[0].value = town;
	}
	if(country != "null"){
		document.getElementsByName("country")[0].value = country;
	}
	if(failed == "true"){
		window.alert("Missing First Name and/or a Form of Contact");
		if(fname == "null"){
			document.getElementById("fn").style.color="red";
		}
		if(telephone == "null" && mobile == "null" && email == "null"){
			document.getElementById("contact1").style.color="red";
			document.getElementById("contact2").style.color="red";
			document.getElementById("contact3").style.color="red";
		}
	}
});
</script>  
</html>