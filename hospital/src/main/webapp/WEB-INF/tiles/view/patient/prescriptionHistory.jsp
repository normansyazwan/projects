<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="page-header">
	<h3>Prescription History</h3>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<label>Patient Name</label>
		</div>
		<div class="col-md-8">${patient.firstName}&nbsp;
			${patient.lastName}</div>
		<div class="col-md-2">
		
			<a href='<c:url value="/patients/${patient.personId}" />' class="btn btn-default btn-sm">Profile</a>
		
			<a href='<c:url value="/patients/${patient.personId}/prescription" />'
			class="btn btn-default btn-sm">Prescription</a>
		</div>	
	</div>
	<div class="row">		
		<div class="col-md-2">
			<label>Existing Ailments</label>
		</div>
		<c:choose>
			<c:when test="${patient.existingAilments ne null}">
			<div class="col-md-10 text-left text-danger">${patient.existingAilments}</div>
			</c:when>
		<c:otherwise>
			<div class="col-md-10 text-left text-success">None</div>
		</c:otherwise>
		</c:choose>
	</div>
	<div class="row">		
		<div class="col-md-2">
			<label>Allergies</label>
		</div>
		<c:choose>
			<c:when test="${patient.allergies ne null}">
			<div class="col-md-10 text-left text-danger">${patient.allergies}</div>
		</c:when>
		<c:otherwise>
			<div class="col-md-10 text-left text-success">None</div>
		</c:otherwise>
		</c:choose>
		
	</div>
</div>

<div class="container-fluid">

	<table
		class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>Sr.No.</th>
				<th>Prescription Id</th>
				<th>Symptoms</th>
				<th>Prescription</th>
				<th>Medical Tests</th>
				<th>Comments</th>
				<th>Date of Visit</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${patient.prescriptions}" var="p"
				varStatus="counter">
				<tr style="">
					<td>${counter.count}</td>
					<td>${p.prescriptionId}</td>
					<td>${p.symptoms }</td>
					<td>${p.prescription }</td>
					<td>${p.medicalTests }</td>
					<td>${p.comments }</td>
					<td>
					<fmt:formatDate value="${p.createdTimestamp}" var="createdTimestamp"
					pattern="dd-MMM-yyyy h:m a" />
					${createdTimestamp}</td>
					<td><a href='<c:url value="/patients/${patient.personId}/prescription" />'
			class="btn btn-default btn-sm">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
