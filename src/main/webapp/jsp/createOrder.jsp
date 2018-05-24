<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form method="POST" modelAttribute="oid">
		Ship Name:
		<form:select path="ship">
		<form:option  value="Please Select a ship." />
			 <form:options items="${shipList}" value="${ship}" />
			
		</form:select><br/>
		Company Name:
		<form:select path="shippingCompany">
		<form:option  value="Please Select a shipping Company." />
			 <form:options items="${shipcList}" value="${shippingCompany}" />
		</form:select><br/>
		
		<input type="submit" />

	</form:form>
	<a href="index.html">HOME</a>
</body>
</html>