<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
	<div class="row" style="height: 90px; background-color: #eee;">
		<div class="col-xs-8 col-sm-8"
			style="height: 100%">
			
			<c:forEach items="${authorities}" var="authority">
				<li>${authority.authority}</li>
			</c:forEach>
			
			</div>
		<div class="col-xs-4 col-sm-4"
			style="height: 100%;">
			
			<sec:authorize access="! isAuthenticated()">
				<form name='loginForm'
					action="<c:url value='j_spring_security_check' />" method='POST'
					class="form-horizontal" style="padding-top: 20px;">
	
					<div class="form-group">
						<div class="col-xs-5">
							<input type="text" id="userName"
								class="form-control input-sm col-xs-5" name="username"
								placeholder="username" width="100" />
						</div>
						<div class="col-xs-4">
							<input type="password" name="password"
								class="form-control input-sm" placeholder="password" />
						</div>
						<div class="col-xs-3">
							<input name="loginSubmit" type="submit" value="Log In"
								class="btn btn-primary btn-sm" />
	
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
			
				<div style="padding-top: 20px;">Welcome <sec:authentication property="principal.username" /></div>
				<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
			</sec:authorize>
		</div>
	</div>
</div>
