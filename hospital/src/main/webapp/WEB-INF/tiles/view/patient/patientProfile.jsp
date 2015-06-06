<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${patient.firstName}'s Profile</h3>

<table>
	<tr>
		<td><label>Patient Id:</label></td>
		<td>${patient.patientId}</td>
	</tr>
	<tr>
		<td><label>Name:</label></td>
		<td>${patient.firstName} &nbsp; ${patient.lastName}</td>
	</tr>
	<tr>
		<td><label>Gender</label></td>
		<td>${patient.gender}</td>
	</tr>
	<tr>
		<td><label>Date of Birth:</label></td>
		<td>
			<fmt:formatDate value="${patient.dateOfBirth}" var="dateString" pattern="dd-MMM-yyyy" /> 
			${dateString}
		</td>
	</tr>
	<tr>
		<td><label>Email:</label></td>
		<td>${patient.email}</td>
	</tr>
	<tr>
		<td><label>Mobile:</label></td>
		<td>${patient.mobile}</td>
	</tr>
	<tr>
		<td><label>Landline Phone:</label></td>
		<td>${patient.phone}</td>
	</tr>
	<tr>
		<td><label>Address: </label></td>
		<td>
			${patient.address.apartment}<br/>
			${patient.address.street}<br/>
			${patient.address.area}<br/>
			${patient.address.city.enumValue}<br/>
		</td>
	</tr>
</table>

</body>
</html>