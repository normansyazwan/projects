<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4">
			<div class="jumbotron">
				aaaaaaaaaaa
			</div>
		</div>
		<div class="col-sm-4">
			<div class="jumbotron">
			
				<form name="ajaxform" id="ajaxform" action="<c:url value="/ajax" />" method="post">
					<label for="query">Search:</label> 
					<button id="ajaxFormSubmit">Search</button>
				</form>
			
			</div>
		</div>
		<div class="col-sm-4"><div id="outp">outp</div></div>
	</div>
</div>
