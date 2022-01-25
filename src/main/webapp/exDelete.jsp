<!--Sebastian Shaimas-->
<!--CS 351, Section 1-->
<!--Assignment 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%if("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("button")!=null){%>
		<jsp:useBean id="DeleteBean" class="edu.csueastbay.sshaimas.DeleteBean">
		</jsp:useBean>
		<% 
		DeleteBean.deleteRecord(Integer.parseInt(request.getParameter("deleteID")));
		response.sendRedirect("DeleteAddress.jsp");
	}%>
</body>
</html>