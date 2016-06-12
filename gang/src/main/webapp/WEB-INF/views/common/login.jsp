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
		<img src=" <c:url value='/resources/images/padlock-small.png' />" alt="" class="img">
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
				<form name='loginForm'
					action="<c:url value='j_spring_security_check' />" method='POST'>

					<div>
						<h4>Login Please...</h4>
						<input type="text" id="userName"
							class="form-control input-sm chat-input" name="username"
							placeholder="username" /> <br /> <input type="password"
							name="password" class="form-control input-sm chat-input"
							placeholder="password" /> <br>
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
			<a href='<c:url value="/" />'>No Thanks! Just take me to home page.</a>
		</div>
		<div class="col-md-4"></div>
	</div>

</div>