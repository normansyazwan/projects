<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container-fluid well well-sm" style="margin-top:50px;">
	<div class="row">
		<div class="col-sm-8">We help you find your perfect partner in life!</div>
		<div class="col-sm-2 text-right">
		</div>
		<div class="col-sm-1 text-right">
			<a href='<c:url value="/aboutUs" />'>About Us</a>
		</div>
		<div class="col-sm-1 text-right">
			<a href='<c:url value="/contactUs" />'>Contact Us</a>
		</div>
	</div>
</div>