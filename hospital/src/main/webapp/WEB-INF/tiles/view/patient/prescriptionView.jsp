<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="page-header">
	<h3>${patient.firstName}'s Prescription</h3>
</div>


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
			<c:when test="${patient.existingAilments ne null && patient.existingAilments.trim().length() gt 0}">
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
			<c:when test="${patient.allergies ne null && patient.allergies.trim().length() gt 0}">
				<div class="col-md-5 text-danger">${patient.allergies}</div>			
			</c:when>
			<c:otherwise>
				<div class="col-md-5 text-success">None</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<a href='<c:url value="/patients/${patient.personId}" />'
					class="btn btn-default btn-sm">View Profile</a>
			
			<a href='<c:url value="/patients/${patient.personId}/prescription" />'
						class="btn btn-default btn-sm">New Prescription</a>	
				
			<a href='<c:url value="/patients/${patient.personId}/prescriptions" />'
				class="btn btn-default btn-sm">Back to Prescription History</a>	
		</div>
	</div>
</div>
