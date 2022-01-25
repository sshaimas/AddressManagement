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
	<%if("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("register")!=null){%>
		<jsp:useBean id="AddressBean" class="edu.csueastbay.sshaimas.AddressBean">
		<jsp:setProperty name="AddressBean" property="*" />
		</jsp:useBean>
		<%if(AddressBean.checkValidity()){
			AddressBean.insertToDB();
			
			//Excercise 2, Part B
			//response.sendRedirect("DeleteAddress.jsp");
			
			//Excercise 2, Part D
			response.sendRedirect("SearchAddress.jsp");
		}
		else{
			session.setAttribute("fname", AddressBean.getFname());
			session.setAttribute("sname", AddressBean.getSname());
			session.setAttribute("telephone", AddressBean.getTelephone());
			session.setAttribute("mobile", AddressBean.getMobile());
			session.setAttribute("email", AddressBean.getEmail());
			session.setAttribute("address", AddressBean.getAddress());
			session.setAttribute("postalnr", AddressBean.getPostalnr());
			session.setAttribute("town", AddressBean.getTown());
			session.setAttribute("country", AddressBean.getCountry());
			session.setAttribute("failed", "true");
			response.sendRedirect("Register.jsp");
		}
	} %>

</body>
</html>