<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SS RAD Final Project</title>
	</head>
	<body>
		<h1>Orders</h1>
		<table border="1">
		<tr>
			<th>Order Number</th>
			<th>Shipping Company Name</th>
			<th>Ship Name</th>
			<th>Date</th>
		</tr>
		<tr>
			<c:forEach items="${order}" var="orders">
				<tr>
					<td>${orders.oid}</td>
					<td>${orders.shippingCompany.name}</td>
					<td>${orders.ship.name}</td>
					<td>${orders.date}</td>
			</c:forEach>
		</tr>
	</table>
	<a href="index.html">HOME</a>
	</body>
</html>