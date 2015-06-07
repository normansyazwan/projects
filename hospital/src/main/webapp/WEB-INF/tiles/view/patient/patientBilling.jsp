<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h3>Patient Billing</h3>
	<table cellpadding="5" style="width: 300px;">
		<tr>
			<td><label>Patient Id</label></td>
			<td>${patient.patientId}</td>
		</tr>
		<tr>
			<td><label>Patient Name</label></td>
			<td>${patient.firstName}&nbsp;${patient.lastName}</td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
	<hr />
	<table border="1" style="width: 100%;">
		<thead>
			<tr>
				<th>Sr.No</th>
				<th>Item</th>
				<th>Sr.No</th>
				<th>Sr.No</th>
				<th>Sr.No</th>
				<th>Sr.No</th>
			</tr>
		</thead>

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>