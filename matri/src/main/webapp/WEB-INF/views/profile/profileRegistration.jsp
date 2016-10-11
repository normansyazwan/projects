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
				<h3>New Profile Registration</h3>
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
							<form:input path="middleName" value="${middleName}"
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

				<spring:bind path="unlistedCaste">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="unlistedCaste" cssClass="col-sm-2 control-label">Provide Caste if not listed above:</form:label>
						<div class="col-sm-3">
							<form:input path="unlistedCaste" value="${unlistedCaste}"
								cssClass="form-control"  maxlength="100" />
						</div>
						<div class="col-sm-9">
							<form:errors path="unlistedCaste" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="profileCreatedBy">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="profileCreatedBy" cssClass="col-sm-2 control-label">Profile created by:</form:label>
						<div class="col-sm-3">
							<form:input path="profileCreatedBy" value="${profileCreatedBy}"
								cssClass="form-control"  maxlength="100" />
						</div>
						<div class="col-sm-9">
							<form:errors path="profileCreatedBy" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
				<div class="col-sm-12">
					<hr />
				</div>
				<spring:bind path="mobile">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="mobile" cssClass="col-sm-2 control-label">Mobile Number:</form:label>
						<div class="col-sm-3">
							<form:input path="mobile" value="${mobile}"
								cssClass="form-control"  maxlength="10" placeholder="10 digit mobile number"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="mobile" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="mobile2">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="mobile2" cssClass="col-sm-2 control-label">Alternate Mobile Number:</form:label>
						<div class="col-sm-3">
							<form:input path="mobile2" value="${mobile2}"
								cssClass="form-control"  maxlength="10" placeholder="10 digit mobile number"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="mobile2" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="landline">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="landline" cssClass="col-sm-2 control-label">Landline Number:</form:label>
						<div class="col-sm-3">
							<form:input path="landline" value="${landline}"
								cssClass="form-control"  maxlength="20" placeholder="Landline phone number with STD code"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="landline" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>

				<div class="col-sm-12">
					<hr />
				</div>

				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="email" cssClass="col-sm-2 control-label">Email id:</form:label>
						<div class="col-sm-3">
							<form:input path="email" value="${email}"
								cssClass="form-control"  maxlength="180" placeholder="Email id"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="email" cssClass="col-sm-2 control-label">Password:</form:label>
						<div class="col-sm-3">
							<form:password path="email" value="${email}"
								cssClass="form-control"  maxlength="180" placeholder="Email id"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="email" cssClass="col-sm-2 control-label">Confirm Password:</form:label>
						<div class="col-sm-3">
							<form:password path="email" value="${email}"
								cssClass="form-control"  maxlength="180" placeholder="Email id"/>
						</div>
						<div class="col-sm-9">
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</spring:bind>
				
								
				<div class="col-sm-12">
					<hr />
				</div>

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