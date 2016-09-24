<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<div class="page-header">
				<h3>Create New Profile</h3>
			</div>

			<c:if test="${param.status ne null}">
				<p class="bg-success">${param.status}:RegistrationSuccessful!!</p>
			</c:if>

			<form:form method="POST" commandName="profile"
				cssClass="form-horizontal">

				<form:hidden path="profileId" />

				<spring:bind path="firstName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="firstName" cssClass="col-sm-2 control-label">Name:</form:label>
						<div class="col-sm-3">
							<form:input path="firstName" value="${firstName}"
								cssClass="form-control" placeholder="First Name" maxlength="100" />
						</div>
						<div class="col-sm-3">
							<form:input path="lastName" value="${lastName}"
								cssClass="form-control" placeholder="Last Name" maxlength="100" />
						</div>
						<div class="col-sm-4">
							<form:errors path="firstName" cssClass="text-danger"
								class="control-label" />
						</div>
					</div>
				</spring:bind>

				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<input type="submit" value="Save" class="btn btn-success" />
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>