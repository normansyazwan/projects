<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href='<c:url value="/" />'> <img alt="Brand" src="...">
			</a>
		</div>
		
		<sec:authorize access="! isAuthenticated()">
			<c:url value='/profile/registration' var="profileRegistration" />
			<ul class="nav navbar-nav navbar-right">
				<li class="bg-success"><a href="${profileRegistration}">Free Registration!</a></li>
			</ul>
		
			<div class="nav navbar-nav navbar-right">
				
				<c:url value='/j_spring_security_check' var="loginUrl" />
				
				<form name='loginForm'
					action="${loginUrl}" method='POST'
					class="form-horizontal navbar-form">
	
					<div class="form-group">
						<div class="col-xs-5" style="padding-left:0px; padding-right:5px">
							<input type="text" id="userName"
								class="form-control input-sm col-xs-5" name="username"
								placeholder="username" width="100" />
						</div>
						<div class="col-xs-4" style="padding-left:0px; padding-right:5px">
							<input type="password" name="password"
								class="form-control input-sm" placeholder="password" />
						</div>
						<div class="col-xs-3 text-right" style="padding-left:10px; padding-right:10px;">
							<input name="loginSubmit" type="submit" value="Log In"
								class="btn btn-primary btn-sm" />
	
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<%-- 
				<a href="#" class="small">Forgot Password?</a>
				<a href="#" class="small">Forgot User Id?</a>
				--%>
			</div>
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Welcome <sec:authentication property="principal.username" /></a></li>
				<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</ul>
		</sec:authorize>
	</div>
</nav>
