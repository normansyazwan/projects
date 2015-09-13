<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<div class="page-header">
	<h3>Employees</h3>
</div>

<div class="container-fluid">

	<table
		class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Designation</th>
				<th>Date Of Joining</th>
				<th>Gender</th>
				<th>Mobile/Phone</th>
				<th>Email</th>
				<th>Comments</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="e">
				<tr style="">
					<td><small>${e.personId}</small></td>
					<td><small><a href='<c:url value="/employees/${e.personId}" />'>
							${e.firstName}&nbsp;&nbsp;${e.lastName} </a></small></td>
					<td><small>${e.designation}</small></td>
					<td><small><fmt:formatDate value="${e.dateOfJoining}" var="dateString"
							pattern="dd-MMM-yyyy" /> ${dateString}</small></td>
					<td><small>${e.gender}</small></td>
					<td><small>${e.mobile}
					<c:if test="${e.phone ne null}">
						&nbsp; ${e.phone}
					</c:if>
					</small></td>
					<td><small>${e.email}</small></td>
					<td><small>${e.comments}</small></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>