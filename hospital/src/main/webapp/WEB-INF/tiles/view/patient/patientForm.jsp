<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<h3>Patient Registration Form</h3>
	
	<c:if test="${param.status ne null}">
		<p class="bg-success">${param.status}: Record saved successfully. Patient Id is &nbsp; ${param.patientId}</p>
	</c:if>
	
	<form:form action="add" method="POST" commandName="patient">
		<table>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2"><form:errors path="*" cssClass="formError" /></td>
			</tr>
			<tr>
				<td><form:label path="personId">Patient Id:</form:label></td>
				<td><form:input path="personId" readonly="true"
						value="${personId}" /></td>
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
				<td><form:input path="email" value="${email}" maxlength="200"/></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile:</form:label></td>
				<td><form:input path="mobile" value="${mobile}" maxlength="10" /></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><form:label path="phone">Landline Phone:</form:label></td>
				<td><form:input path="phone" value="${phone}" maxlength="15" /></td>
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
				<td>&nbsp;</td>
				<td><button value="Reset" class="btn btn-default">Reset</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="Save" class="btn btn-primary"/></td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</form:form>

	<table>
		<tr>
			<td><a href='<c:url value="/patients" />'>List Patients</a></td>
		</tr>
	</table>
