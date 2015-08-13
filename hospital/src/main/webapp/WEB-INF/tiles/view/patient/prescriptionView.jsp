<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="page-header">
	<h3>${prescription.patient.firstName}'s Prescription 
	<small>Dated: <fmt:formatDate value="${prescription.createdTimestamp}" var="createdTimestamp"
					pattern="dd-MMM-yyyy h:m a" />
					${createdTimestamp}</small>
	
	</h3>
</div>

<div class="container-fulid">

	<div class="row">
		<div class="col-md-7">

			<div class="row">
				<div class="col-md-3">
					<label>Symptoms:</label>
				</div>
				<div class="col-md-9">${prescription.symptoms}</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<label>Prescription:</label>
				</div>
				<div class="col-md-9">${prescription.prescription}</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<label>Medical Tests:</label>
				</div>
				<div class="col-md-9">${prescription.medicalTests}</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<label>Comments:</label>
				</div>
				<div class="col-md-9">${prescription.comments}</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

		</div>

		<div class="col-md-5">

			<div class="row">
				<div class="col-md-4">
					<label>Patient Id:</label>
				</div>
				<div class="col-md-8">${prescription.patient.personId}</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Name:</label>
				</div>
				<div class="col-md-8">${prescription.patient.firstName}&nbsp;
					${patient.lastName}</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Gender:</label>
				</div>
				<div class="col-md-8">${prescription.patient.gender}</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Blood Group:</label>
				</div>
				<div class="col-md-8">${prescription.patient.bloodGroup}</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Date of Birth</label>
				</div>
				<div class="col-md-8">
					<fmt:formatDate value="${prescription.patient.dateOfBirth}"
						var="dateString" pattern="dd/MMM/yyyy" />
					${dateString}
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Age</label>
				</div>
				<div class="col-md-8">${prescription.patient.age}</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Existing Ailments:</label>
				</div>

				<c:choose>
					<c:when
						test="${prescription.patient.existingAilments ne null && prescription.patient.existingAilments.trim().length() gt 0}">
						<div class="col-md-8 text-danger">${prescription.patient.existingAilments}</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-8 text-success">None</div>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Allergies:</label>
				</div>

				<c:choose>
					<c:when
						test="${prescription.patient.allergies ne null && prescription.patient.allergies.trim().length() gt 0}">
						<div class="col-md-8 text-danger">${prescription.patient.allergies}</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-8 text-success">None</div>
					</c:otherwise>
				</c:choose>

			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

			<div class="col-md-12">
				<a
					href='<c:url value="/patients/${prescription.patient.personId}" />'
					class="btn btn-default btn-sm">View Profile</a> <a
					href='<c:url value="/patients/${prescription.patient.personId}/prescription" />'
					class="btn btn-default btn-sm">New Prescription</a> <a
					href='<c:url value="/patients/${prescription.patient.personId}/prescriptions" />'
					class="btn btn-default btn-sm">Back to Prescription History</a>
			</div>

		</div>

	</div>

</div>
