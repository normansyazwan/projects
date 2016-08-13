<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container-fulid">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-10">

			<div class="page-header">
				<h3>${patient.firstName}'s Profile</h3>
			</div>


			<c:if test="${param.insertStatus ne null}">
				<p class="bg-success well-sm">${param.insertStatus}:Record saved
					successfully.</p>
			</c:if>
			<c:if test="${param.updateStatus ne null}">
				<p class="bg-success well-sm">${param.updateStatus}:Record updated
					successfully.</p>
			</c:if>


			<div class="row">
				<div class="col-md-2">
					<label>Patient Id:</label>
				</div>
				<div class="col-md-5">${patient.patientId}</div>
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
					<label>Date of Birth</label>
				</div>
				<div class="col-md-5">
					<fmt:formatDate value="${patient.dob}" var="dateString"
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
				<div class="col-md-12">
					<hr />
				</div>
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
					<label>Address:</label>
				</div>
				<div class="col-md-5">
				<c:if test="${patient.address.apartment ne null}">
					${patient.address.apartment}<br />
				</c:if>
				<c:if test="${patient.address.street ne null}">
					${patient.address.street}<br />
				</c:if>
				<c:if test="${patient.address.area ne null}">
					${patient.address.area}<br />
				</c:if>
				<c:if test="${patient.address.city ne null}">
					${patient.address.city}<br />
				</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<hr />
				</div>
			</div>

			<div class="row">
				<div class="col-md-2">
					<label>Blood Group:</label>
				</div>
				<div class="col-md-5">${patient.bloodGroup}</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label>Existing Ailments:</label>
				</div>
				<c:choose>
					<c:when
						test="${patient.existingAilments ne null && patient.existingAilments.trim().length() gt 0}">
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
					<c:when
						test="${patient.allergies ne null && patient.allergies.trim().length() gt 0}">
						<div class="col-md-5 text-danger">${patient.allergies}</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-5 text-success">None</div>
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
					<a href='<c:url value="/patients/${patient.patientId}/edit" />'
						class="btn btn-default btn-sm" title="Edit this Patient"><span class="glyphicon glyphicon-wrench"></span></a>
					<a href='<c:url value="/patients/${patient.patientId}/delete" />'
						class="btn btn-default btn-sm" title="Delete this Patient"><span class="glyphicon glyphicon-trash"></span></a>
					<a href='<c:url value="/patients/${patient.patientId}/prescriptions" />'
						class="btn btn-default btn-sm" title="Prescription History"><span class="glyphicon glyphicon-list-alt"></span></a>
						
					<%-- action buttons  --%>
					<div class="btn-group">
						<a href='<c:url value="/patients/${patient.patientId}/edit" />'
						class="btn btn-default btn-sm" title="Edit this Patient">Edit Profile</a>
						<a href='<c:url value="/patients/${patient.patientId}/assesment" />'
						class="btn btn-default btn-sm" title="New Assessment">New Assessment</a>
						
						<a href='<c:url value="/patients/${patient.patientId}/treatment" />'
						class="btn btn-default btn-sm" title="Add Sitting">Add Sitting</a>
						<a href='<c:url value="/patients/${patient.patientId}/history" />'
						class="btn btn-default btn-sm" title="Patient History">History</a>
					</div>	
				</div>
			</div>
		</div>
	</div>
</div>