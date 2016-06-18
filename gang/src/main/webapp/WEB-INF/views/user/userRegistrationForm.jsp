<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<div class="container">
	<div class="row">
		<div class="col-sm-4">content....</div>
		<div class="col-sm-8">
			<div class="page-header">
				<h3>Create an Account</h3>
				<h4>Its free!</h4>
			</div>

			<c:if test="${param.status ne null}">
				<p class="bg-success">${param.status}:RegistrationSuccessful!!</p>
			</c:if>

			<form:form method="POST" commandName="user"
				cssClass="form-horizontal">

				<c:choose>
					<c:when test="${userId > 0}">
						<div class="form-group">
							<form:label path="personId" cssClass="col-sm-2 control-label">User Id:</form:label>
							<div class="col-sm-10">${userId}</div>
							<form:hidden path="userId" />
						</div>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>

				<div class="form-group">
					<form:label path="firstName" cssClass="col-sm-2 control-label">Name:</form:label>
					<div class="col-sm-3">
						<form:input path="firstName" value="${firstName}"
							cssClass="form-control" placeholder="First Name" />
					</div>
					<div class="col-sm-3">
						<form:input path="lastName" value="${lastName}"
							cssClass="form-control" placeholder="Last Name" />
					</div>
					<div class="col-sm-4">
						<form:errors path="firstName" cssClass="text-danger"
							class="control-label" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="gender" cssClass="col-sm-2 control-label">Gender</form:label>
					<div class="col-sm-6">
						<label class="radio-inline"> <form:radiobutton
								path="gender" value="Male" /> Male
						</label> <label class="radio-inline"> <form:radiobutton
								path="gender" value="Female" /> Female
						</label>
					</div>
					<div class="col-sm-4">
						<form:errors path="gender" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
					<div class="col-sm-6">
						<fmt:formatDate value="${employee.dateOfBirth}" var="dateString"
							pattern="dd/MM/yyyy" />
						<form:input path="dateOfBirth" value="${dateString}"
							cssClass="form-control" placeholder="dd/MM/yyyy" />
					</div>
					<div class="col-sm-4">
						<form:errors path="dateOfBirth" cssClass="text-danger" />
					</div>
				</div>

				<hr />

				<div class="form-group">
					<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
					<div class="col-sm-6">
						<form:input path="email" value="${email}" cssClass="form-control"
							placeholder="e.g. email@gmail.com" />
					</div>
					<div class="col-sm-4">
						<form:errors path="email" cssClass="text-danger"
							class="control-label" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="mobileNumber" cssClass="col-sm-2 control-label">Mobile Number</form:label>
					<div class="col-sm-6">
						<form:input path="mobileNumber" value="${mobileNumber}"
							cssClass="form-control" placeholder="10 Digit Mobile Number"
							maxlength="10" />
					</div>
					<div class="col-sm-4">
						<form:errors path="mobileNumber" cssClass="text-danger" />
					</div>
				</div>

				<hr />
				<div class="form-group">
					<form:label path="address.apartment"
						cssClass="col-sm-2 control-label">Apartment</form:label>
					<div class="col-sm-6">
						<form:input path="address.apartment" value="${address.apartment}"
							cssClass="form-control" placeholder="Apartment No and Building" />
					</div>
					<div class="col-sm-4">
						<form:errors path="address.apartment" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="address.locality"
						cssClass="col-sm-2 control-label">Locality</form:label>
					<div class="col-sm-6">
						<form:input path="address.locality" value="${address.locality}"
							cssClass="form-control" placeholder="Locality" />
					</div>
					<div class="col-sm-4">
						<form:errors path="address.locality" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="address.state" cssClass="col-sm-2 control-label">State</form:label>
					<div class="col-sm-6">
						<form:input path="address.state" value="${address.state}"
							cssClass="form-control" placeholder="State" />
					</div>
					<div class="col-sm-4">
						<form:errors path="address.state" cssClass="text-danger" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<button value="Reset" class="btn btn-default ">Reset</button>
						<input type="submit" value="Create an account"
							class="btn btn-success" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
