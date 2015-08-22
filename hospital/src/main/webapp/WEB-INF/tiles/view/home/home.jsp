<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="page-header">
	<h3>Dashboard</h3>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-7">
			<security:authorize access="hasAuthority('ADMIN_USER')">
				<img src="<c:url value='/stats/visit-stats.png' />"
					alt="Patient Visit Stats not available!" class="img-rounded">
			</security:authorize>
		</div>
		<div class="col-sm-5">
			<h4>Patients In Database: ${totalPatientCount}</h4>
			<hr />
			<h4>Average Daily prescriptions over last
				${prescriptionAverageForMonths} months: ${averagePatientCount}</h4>
			<hr />
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<img src=" <c:url value='/resources/images/success.png' />" alt="..."
				class="img-rounded">

		</div>
	</div>
	<div class="well well-sm">
		<p>Roles:</p>

		<security:authentication property="authorities" var="authorities" />
		<ul>
			<c:forEach items="${authorities}" var="authority">
				<li>${authority.authority}</li>
			</c:forEach>
		</ul>

	</div>
</div>