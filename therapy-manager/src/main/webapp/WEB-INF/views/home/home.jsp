<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<hr />

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4">
			<div class="jumbotron">
				<a href="<c:url value="/patients/?page=1" />" class="btn btn-success">View All Patients <span class="badge">Total count ${patientCount}</span></a>
			</div>
		</div>
		<div class="col-sm-4">.col-sm-4</div>
		<div class="col-sm-4">.col-sm-4</div>
	</div>
</div>
