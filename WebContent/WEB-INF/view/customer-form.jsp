<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Form</h2>

		</div>
	</div>
	<div id="container">
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			<h3>Customer Details</h3>
			
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Fisrt Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
										<tr>
						<td><label>FisrtName:</label></td>
						<td><input type="submit" value="save" class=""/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>

	</div>
</body>
</html>