<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container" onload='document.loginForm.username.focus();'>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 text-center">
			<img src=" <c:url value='/resources/images/gang-logo.png' />" alt=""
				class="img">
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="row">
				<c:if test="${not empty error}">
					<div class="bg-danger well-sm">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="bg-info well-sm">${msg}</div>
				</c:if>
			</div>
			<div style="height: 20px;"></div>
			<div class="row well">
				<form name='loginForm' class="form-horizontal"
					action="<c:url value='/login' />" method='POST'>

					<div>
						<c:if test="${param.error != null}">
							<p>Invalid Username and password.</p>
						</c:if>


						<h4>Login Please...</h4>
						<div class="form-group">
							<label class="control-label">Password:</label> <input type="text"
								id="userName" class="form-control input-sm" name="username"
								placeholder="username" /> <br />

						</div>

						<label>Password:</label> <input type="password" name="password"
							class="form-control input-sm" placeholder="password" /> <br>
						<div class="wrapper">
							<span class="group-btn"> <input name="submit"
								type="submit" value="submit" class="btn btn-primary btn-md" />
							</span>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<a href='<c:url value="/" />'>Take me to home page, I will
				register later...</a>
		</div>
		<div class="col-md-4"></div>
	</div>

</div>