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
				<th>Id</th>
				<th>Name</th>
				<th>Date Of Birth</th>
				<th>Gender</th>
				<th>Mobile/Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${patients}" var="p">
				<tr style="">
					<td><small>${p.personId}</small></td>
					<td><small><a href='<c:url value="/patients/${p.personId}" />'>
							${p.firstName}&nbsp;&nbsp;${p.lastName} </a></small></td>
					<td><small><fmt:formatDate value="${p.dateOfBirth}" var="dateString"
							pattern="dd/MMM/yyyy" /> ${dateString}</small></td>
					<td><small>${p.gender}</small></td>
					<td><small>${p.mobile}<br /> 
					<c:if test="${p.phone ne null}">
						${p.phone}
					</c:if>
					</small></td>
					<td><small>${p.email}</small></td>
					<td><small>${p.address.apartment}<br />
							${p.address.street}<br /> ${p.address.area}<br />
					</small></td>
					<td>
												
						<a href='<c:url value="/patients/${p.personId}/prescription" />'
						class="btn btn-default btn-sm">Prescription</a>
						
						<a href='<c:url value="/patients/${p.personId}/prescriptions" />'
						class="btn btn-default btn-sm">Prescription History</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
