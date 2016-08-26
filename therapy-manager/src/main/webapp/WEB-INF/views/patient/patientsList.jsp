<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Patients</h3>
</div>

<div class="container-fluid">

	<div class="row">
		
		<div class="col col-sm-12">
			
			<ul class="pagination small">
				<c:set var="totalCount" scope="session" value="${fn:length(patients)}"/>
				<c:set var="perPage" scope="session" value="10"/>
				
				<c:forEach var="boundaryStart" begin="1" end="${totalCount}" step="${perPage}">
					<li>
						<a href="?page=<c:out value="${boundaryStart}"/>">
						
						<c:out value="${boundaryStart}"/>
						-
						<c:choose>
							<c:when test="${(boundaryStart + perPage - 1 ) lt fn:length(patients)}">
								<c:out value="${boundaryStart + perPage - 1}"/>
							</c:when>
							<c:otherwise>
								<c:out value="${fn:length(patients) - 1}"/>
							</c:otherwise>
						</c:choose>
						</a>
					</li>
				</c:forEach>	
				
			</ul>
		
		</div>
	</div>

	<table
		class="table table-condensed table-striped table-hover table-responsive small">
		<thead>
			<tr>
				<th>Sr.No.</th>
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
			
			<c:forEach var="p" items="${patients}" varStatus="status" begin="${param.page -1}" end="${param.page + perPage - 1}">
				
				<tr>
					<td>${status.index + 1}</td>
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