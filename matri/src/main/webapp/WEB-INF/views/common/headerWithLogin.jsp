<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<nav class="navbar navbar-default">

	<div class="container-fluid ">
		<div class="navbar-header">
		</div>

		<ul class="nav navbar-nav navbar-right">
			<spring:url value="/profile/new" var="profileRegistrationUrl" scope="page"/>
			<li class="bg-success"><a href="${profileRegistrationUrl}"><strong>Free
						Registration!</strong></a></li>
			<li><a href='<spring:url value="/login" />'><strong>Login</strong></a></li>
		</ul>

	</div>
</nav>
