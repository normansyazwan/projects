<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h3>Patient Prescription Form</h3>
</div>


<c:if test="${param.status ne null}">
	<p class="bg-success well well-sm">${param.status}:Recordsaved
		successfully. Patient Id is &nbsp; ${param.patientId}</p>
</c:if>

<div class="row">
	<div class="col-md-6">

		<form:form class="form-horizontal" method="post"
			commandName="prescription">
			<div class="form-group">
				<form:errors path="symptoms" cssClass="text-danger" />
				<input type="hidden" name="prescriptionId"
					value="${prescription.prescriptionId}" />
			</div>
			<div class="form-group">
				<label for="symptoms">Symptoms</label>
				<form:textarea path="symptoms" class="form-control" rows="3"
					cols="50"></form:textarea>
			</div>
			<div class="form-group">
				<label for="prescription">Prescription</label>
				<form:textarea path="prescription" class="form-control" rows="3"
					cols="50"></form:textarea>
			</div>
			<div class="form-group">
				<label for="medicalTests">Medical Tests</label>
				<form:textarea path="medicalTests" class="form-control" rows="3"
					cols="50"></form:textarea>
			</div>
			<div class="form-group">
				<label for="comments">Comments</label>
				<form:textarea path="comments" class="form-control" rows="3"
					cols="50"></form:textarea>
			</div>
			<div class="form-group">
				<a
					href='<c:url value="/patients/${patient.personId}/prescription" />'
					class="btn btn-default btn-sm">Cancel</a>
				<button class="btn btn-sm btn-primary">Save</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Patient Id</label>
			</div>
			<div class="col-md-7">${patient.personId}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Patient Name</label>
			</div>
			<div class="col-md-7">${patient.firstName}&nbsp;
				${patient.lastName}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Gender</label>
			</div>
			<div class="col-md-7">${patient.gender}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Blood Group</label>
			</div>
			<div class="col-md-7">${patient.bloodGroup}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Age</label>
			</div>
			<div class="col-md-7">${patient.age}</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Date of Birth</label>
			</div>
			<div class="col-md-7">
				<fmt:formatDate value="${patient.dateOfBirth}" var="dateString"
					pattern="dd-MMM-yyyy" />
				${dateString}
			</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Address:</label>
			</div>
			<div class="col-md-7">${patient.address.apartment}<br />
				${patient.address.street}<br /> ${patient.address.area}<br /> <br />
			</div>
		</div>
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Existing Ailments</label>
			</div>
			
			<c:choose>
				<c:when
					test="${patient.existingAilments ne null and patient.existingAilments.length() > 0}">
					<div class="col-md-7 text-left text-danger">${patient.existingAilments}</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-7 text-left text-success">None</div>
				</c:otherwise>
			</c:choose>

		</div>
		
		<div class="row">
			<div class="col-md-5 text-right">
				<label>Allergies</label>
			</div>
			
			<c:choose>
				<c:when
					test="${patient.allergies ne null && patient.allergies.trim().length() gt 0}">
					<div class="col-md-7 text-danger">${patient.allergies}</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-7 text-success">None</div>
				</c:otherwise>
			</c:choose>
		
		</div>

		<div class="row">
			<div class="col-md-12">
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<a href='<c:url value="/patients/${patient.personId}" />'
					class="btn btn-default btn-sm">View Profile</a> <a
					href='<c:url value="/patients/${patient.personId}/prescriptions" />'
					class="btn btn-default btn-sm">Prescription History</a>
			</div>
		</div>
	</div>
</div>