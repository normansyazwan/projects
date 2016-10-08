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
		<div class="col-sm-1"></div>
		<div class="col-sm-11">
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
							<form:input path="lastName" value="${middleName}"
								cssClass="form-control" placeholder="Middle Name"
								maxlength="100" />
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

				<spring:bind path="gender">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="gender" cssClass="col-sm-2 control-label">Gender:</form:label>
						<div class="col-sm-6">
							<div class="col-sm-6">
								<label class="radio-inline"> <form:radiobutton
										path="gender" value="Male" /> Male
								</label> <label class="radio-inline"> <form:radiobutton
										path="gender" value="Female" /> Female
								</label>
							</div>
						</div>
						<div class="col-sm-3"></div>
						<div class="col-sm-4">
							<form:errors path="gender" cssClass="text-danger"
								class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="dateOfBirth">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
						<div class="col-sm-3">
							<fmt:formatDate value="${dob}" var="dateString"
								pattern="dd/MM/yyyy" />
							<form:input path="dateOfBirth" value="${dateString}"
								cssClass="form-control" placeholder="dd/MM/yyyy" maxlength="10" />
						</div>
						<div class="col-sm-9">
							<form:errors path="dateOfBirth" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="maritalStatus">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="maritalStatus" cssClass="col-sm-2 control-label">Marital Status:</form:label>
						<div class="col-sm-3">
							<form:select path="maritalStatus" cssClass="form-control"
								id="maritalStatus">
								<option value="">-- Please Select --</option>
								<c:forEach var="ms" items="${maritalStatusList}">
									<c:choose>
										<c:when test="${ms eq maritalStatus}">
											<form:option value="${ms}">${ms}</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${ms}">${ms}</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</div>
						<div class="col-sm-9">
							<form:errors path="maritalStatus" cssClass="text-danger"
								class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="haveChildren">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="haveChildren" cssClass="col-sm-2 control-label">Have Children:</form:label>
						<div class="col-sm-6">
							<div class="col-sm-12">
								<label class="radio-inline"> <form:radiobutton
										path="haveChildren" value="No" /> No
								</label> <label class="radio-inline"> <form:radiobutton
										path="haveChildren" value="Yes & Living together" /> Yes &amp; Living together
								</label>
								<label class="radio-inline"> <form:radiobutton
										path="haveChildren" value="Yes & Not Living together" /> Yes &amp; Not Living together
								</label>
							</div>
						</div>
						<div class="col-sm-6">
							<form:errors path="haveChildren" cssClass="text-danger"
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