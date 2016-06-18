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
			<a href="<c:url value="/" />">
        		<img src="<c:url value="/resources/images/gang-logo.png"/>" alt="..." width="70" height="25">
     		 </a>
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
			Login / <a href="<c:url value="/user/register" />" >Sign-up</a>
		</div>
	</div>
