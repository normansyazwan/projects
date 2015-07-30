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
	<h3>${patient.firstName}'sProfile</h3>

	<div class="container-fulid">
		<div class="row">
			<div class="col-md-2">
				<label>Patient Id:</label>
			</div>
			<div class="col-md-5">${patient.personId}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Name:</label>
			</div>
			<div class="col-md-5">${patient.firstName}&nbsp;
				${patient.lastName}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Gender:</label>
			</div>
			<div class="col-md-5">${patient.gender}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Blood Group:</label>
			</div>
			<div class="col-md-5">${patient.bloodGroup}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Date of Birth</label>
			</div>
			<div class="col-md-5">
				<fmt:formatDate value="${patient.dateOfBirth}" var="dateString"
					pattern="dd/MMM/yyyy" />
				${dateString}
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Age</label>
			</div>
			<div class="col-md-5">${patient.age}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Email:</label>
			</div>
			<div class="col-md-5">${patient.email}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Mobile:</label>
			</div>
			<div class="col-md-5">${patient.mobile}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Landline Phone:</label>
			</div>
			<div class="col-md-5">${patient.phone}</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Address:</label>
			</div>
			<div class="col-md-5">${patient.address.apartment}<br />
				${patient.address.street}<br /> ${patient.address.area}<br />
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Existing Ailments:</label>
			</div>
			<c:choose>
				<c:when test="${patient.existingAilments ne null}">
					<div class="col-md-5 text-danger">${patient.existingAilments}</div>			
				</c:when>
				<c:otherwise>
					<div class="col-md-5 text-success">None</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label>Allergies:</label>
			</div>
			<c:choose>
				<c:when test="${patient.allergies ne null}">
					<div class="col-md-5 text-danger">${patient.allergies}</div>			
				</c:when>
				<c:otherwise>
					<div class="col-md-5 text-success">None</div>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<a href='<c:url value="/patient/edit/${patient.personId}" />'
					class="btn btn-default btn-sm">Edit</a>
				<a href='<c:url value="/patients/${patient.personId}/prescriptions" />'
					class="btn btn-default btn-sm">Prescription History</a>	
			</div>
		</div>
	</div>

</body>
</html>