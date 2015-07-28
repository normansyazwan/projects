<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Patient Prescription Form</h3>

<c:if test="${param.status ne null}">
	<p class="bg-success">${param.status}:Record saved successfully.
		Patient Id is &nbsp; ${param.patientId}</p>
</c:if>

<div class="row">
	<div class="col-md-6">
		<form class="form-horizontal" method="post">
			<div class="form-group">
				<label for="symptoms">Symptoms</label>
				<textarea name="symptoms"  class="form-control" rows="3" cols="50"></textarea>
			</div>
			<div class="form-group">
				<label for="prescription">Prescription</label>
				<textarea name="prescription" class="form-control" rows="3" cols="50"></textarea>
			</div>
			<div class="form-group">
				<label for="medicalTests">Medical Tests</label>
				<textarea name="medicalTests" class="form-control" rows="3" cols="50"></textarea>
			</div>
			<div class="form-group">
				<label for="comments">Comments</label>
				<textarea name="comments" class="form-control" rows="3" cols="50"></textarea>
			</div>
			<div class="form-group">
				<button class="btn btn-default">Cancel</button>
				<button class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-5 text-right"><label>Patient Id</label></div>
			<div class="col-md-7">${patient.personId}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right"><label>Patient Name</label></div>
			<div class="col-md-7">${patient.firstName}&nbsp;
				${patient.lastName}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right"><label>Gender</label></div>
			<div class="col-md-7">${patient.gender}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right"><label>Age</label></div>
			<div class="col-md-7">${patient.age}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right"><label>Date of Birth</label></div>
			<div class="col-md-7"><fmt:formatDate value="${patient.dateOfBirth}" var="dateString"
					pattern="dd-MMM-yyyy" />
				${dateString}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Address:</label>
			</div>
			<div class="col-md-7">${patient.address.apartment}<br />
				${patient.address.street}<br /> ${patient.address.area}<br />
			</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right"><label>Existing Ailments</label></div>
			<div class="col-md-7"><p class="bg-danger">${patient.existingAilments}</p></div>
		</div>
		<div class="row">
			<div class="col-md-12"><a href='<c:url value="/patients/${patient.personId}" />'
					class="btn btn-default btn-sm">View Profile</a>
			<a href='<c:url value="/patients/${patient.personId}/prescriptions" />'
					class="btn btn-default btn-sm">Prescription History</a>
			</div>
		</div>
	</div>
</div>