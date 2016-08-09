<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="page-header">
	<h3>Patients</h3>
</div>
<div class="container-fluid">
	<table
		class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Blood Group</th>
				<th>Existing Ailments</th>
				<th>Allergies</th>
				<th>Mobile</th>
				<th>email</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${patients}">
				<tr>
					<td><a href='<c:url value="/patients/${p.patientId}/profile" />'>
							${p.firstName}&nbsp;${p.lastName}
						</a></td>
					<td>${p.gender}</td>
					<td>${p.age}</td>
					<td>${p.bloodGroup}</td>
					<td>${p.existingAilments}</td>
					<td>${p.allergies}</td>
					<td>${p.mobile}</td>
					<td>${p.email}</td>
					<td>${p.address.string}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>