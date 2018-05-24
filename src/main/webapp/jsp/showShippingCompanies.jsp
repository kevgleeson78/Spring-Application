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
	
	<h1>Shipping Companies</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
		</tr>
		<tr>
			<c:forEach items="${company}" var="company">
				<tr>
					<td>${company.name}</td>
					<td>${company.homePort}</td>
					<td>${company.balance}</td>
					<td>
					<c:forEach items="${company.ships}" var="ships">
						
						<ul>
							<li>${ships.name}, ${ships.metres} Mtrs, ${ships.cost}   </li>
						</ul>
								
						
						
					</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="index.html">HOME</a>
</body>
</html>