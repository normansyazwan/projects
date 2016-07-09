<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="row  gang-header">
	
		<div class="col-sm-1">
			icon here;
		</div>
		<div class="col-sm-4" style="vertical-align: middle;">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for...">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">Go!</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-sm-6 -->
		<div class="col-sm-7">
			Login / Sign-up
			<a href="<c:url value="/resources/css/bootstrap-theme.css" />" >Sign-up</a>
		</div>
	</div>
