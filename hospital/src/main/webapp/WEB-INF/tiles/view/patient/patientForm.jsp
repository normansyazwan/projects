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
<title>Insert title here</title>
</head>
<body>
	<h3>Patient Registration Form</h3>

	<h3 style="color: green">${status}</h3>

	<form:form action="add" method="POST" commandName="patient">
		<table>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2"><form:errors path="*" cssClass="formError" /></td>
			</tr>
			<tr>
				<td><form:label path="patientId">Patient Id:</form:label></td>
				<td><form:input path="patientId" readonly="true"
						value="${patientId}" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="firstName">Patient Name:</form:label></td>
				<td><form:input path="firstName" value="${firstName}" /> <form:input
						path="lastName" value="${lastName}" /></td>
				<td><form:errors path="firstName" cssClass="formError" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender:</form:label></td>
				<td>
					<table>
						<tr>
							<td>Male:</td>
							<td><form:radiobutton path="gender" value="Male" /></td>
						</tr>
						<tr>
							<td>Female:</td>
							<td><form:radiobutton path="gender" value="Female" /></td>
						</tr>
					</table>

				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of Birth:</form:label></td>
				<td><fmt:formatDate value="${dateOfBirth}" var="dateString"
						pattern="dd/MM/yyyy" /> <form:input path="dateOfBirth"
						value="${dateString}" /></td>
				<td><form:errors path="dateOfBirth" cssClass="formError" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" value="${email}" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile:</form:label></td>
				<td><form:input path="mobile" value="${mobile}" maxlength="10" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3"><hr /></td>
			</tr>
			<tr>
				<td><form:label path="address.apartment">Apartment:</form:label></td>
				<td><form:input path="address.apartment"
						value="${address.apartment}" maxlength="200" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="address.street">Street:</form:label></td>
				<td><form:input path="address.street" value="${address.street}"
						maxlength="200" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="address.area">Area:</form:label></td>
				<td><form:input path="address.area" value="${address.area}"
						maxlength="200" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="address.city">City:</form:label></td>
				<td>
				
					<form:select path="address.city.enumId">
						<form:option value="-" label="--Please Select--"/>
						<form:options items="${hospEnums}" itemValue="enumId" itemLabel="enumValue"/>
					</form:select>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button value="Reset">Reset</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="Save" /></td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</form:form>

	<table>
		<tr>
			<td><a href='<c:url value="/patients" />'>List Patients</a></td>
		</tr>
	</table>
	
</body>
</html>