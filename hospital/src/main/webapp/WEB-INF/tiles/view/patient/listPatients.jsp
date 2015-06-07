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
	<h3>Patients</h3>

	<table width="100%" class="zui-table zui-table-highlight-all">
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
				<tr>
					<td>${p.patientId}</td>
					<td><a href='<c:url value="/patients/${p.patientId}" />'>
							${p.firstName}&nbsp;&nbsp;${p.lastName} </a></td>
					<td><fmt:formatDate value="${p.dateOfBirth}" var="dateString"
							pattern="dd/MMM/yyyy" /> ${dateString}</td>
					<td>${p.gender}</td>
					<td>${p.mobile}<c:if test="${p.phone ne null}">
							<hr />
							${p.phone}
					</c:if>
					</td>
					<td>${p.email}</td>
					<td>${p.address.apartment}<br />
						${p.address.street}<br /> ${p.address.area}<br />
						${p.address.city.enumValue}
					</td>
					<td>
						<a href='<c:url value="/patient/billing/${p.patientId}" />'>Billing</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>