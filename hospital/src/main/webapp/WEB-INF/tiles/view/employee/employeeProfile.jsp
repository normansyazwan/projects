<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="page-header">
	<h3>${employee.firstName}'s Profile</h3>
</div>


<c:if test="${param.status ne null}">
	<p class="bg-success well-sm">${param.status}:RecordSaved
		successfully.</p>
</c:if>
<c:if test="${param.update ne null}">
	<p class="bg-success well-sm">${param.update}:RecordUpdated
		successfully.</p>
</c:if>



<div class="container-fulid">
	<div class="row">
		<div class="col-md-2">
			<label>Patient Id:</label>
		</div>
		<div class="col-md-5">${employee.personId}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Name:</label>
		</div>
		<div class="col-md-5">${employee.firstName}&nbsp;
			${employee.lastName}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Gender:</label>
		</div>
		<div class="col-md-5">${employee.gender}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Date of Birth</label>
		</div>
		<div class="col-md-5">
			<fmt:formatDate value="${employee.dateOfBirth}" var="dateString"
				pattern="dd-MMM-yyyy" />
			${dateString}
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Age</label>
		</div>
		<div class="col-md-5">${employee.age}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Email:</label>
		</div>
		<div class="col-md-5">${employee.email}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Mobile:</label>
		</div>
		<div class="col-md-5">${employee.mobile}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Landline Phone:</label>
		</div>
		<div class="col-md-5">${employee.phone}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Address:</label>
		</div>
		<div class="col-md-5">${employee.address.apartment}<br />
			${employee.address.street}<br /> ${employee.address.area}<br />
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<hr />
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Date of Joining:</label>
		</div>
		<div class="col-md-5">
		<fmt:formatDate value="${employee.dateOfJoining}" var="joiningDateString"
				pattern="dd-MMM-yyyy" />
		${joiningDateString}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Designation:</label>
		</div>
		<div class="col-md-5">${employee.designation}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Salary:</label>
		</div>
		<div class="col-md-5">${employee.salary}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Comments:</label>
		</div>
		<div class="col-md-5">${employee.comments}</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label>Date of Relieving:</label>
		</div>
		<div class="col-md-5">
		<fmt:formatDate value="${employee.dateOfRelieving}" var="relievingDateString"
				pattern="dd-MMM-yyyy" />
		${relievingDateString}</div>
	</div>


	<div class="row">
		<div class="col-md-12">
			<hr />
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<a href='<c:url value="/employee/edit/${employee.personId}" />'
				class="btn btn-default btn-sm">Edit Profile</a>
		</div>
	</div>
</div>
