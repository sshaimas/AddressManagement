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
	<%if("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("search")!=null){%>
		<jsp:useBean id="SearchBean" class="edu.csueastbay.sshaimas.SearchBean">
		<jsp:setProperty name="SearchBean" property="*" />
		</jsp:useBean>
		<% session.setAttribute("resultTable", (SearchBean.searchDB()));
		response.sendRedirect("SearchAddressResult.jsp");
	} %>
</body>
</html>