<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<div class="container">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<div class="page-header">
				<h3>Patient Registration</h3>
				<h5>Register a new patient here</h5>
			</div>

			<c:if test="${param.status ne null}">
				<p class="bg-success">${param.status}:RegistrationSuccessful!!</p>
			</c:if>

			<form:form method="POST" commandName="patient"
				cssClass="form-horizontal">

				<spring:bind path="firstName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="firstName" cssClass="col-sm-2 control-label">Name:</form:label>
						<div class="col-sm-3">
							<form:input path="firstName" value="${firstName}"
								cssClass="form-control" placeholder="First Name" maxlength="100"/>
						</div>
						<div class="col-sm-3">
							<form:input path="lastName" value="${lastName}"
								cssClass="form-control" placeholder="Last Name" maxlength="100"/>
						</div>
						<div class="col-sm-4">
							<form:errors path="firstName" cssClass="text-danger"
								class="control-label" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="gender" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
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
				</spring:bind>
				<spring:bind path="dob" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="dob" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
					<div class="col-sm-6">
						<fmt:formatDate value="${dob}" var="dateString"
							pattern="dd/MM/yyyy" />
						<form:input path="dob" value="${dateString}"
							cssClass="form-control" placeholder="dd/MM/yyyy" maxlength="10"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="dob" cssClass="text-danger" />
					</div>
				</div>
				</spring:bind>
				
				<hr />
				
				<spring:bind path="existingAilments" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="existingAilments" cssClass="col-sm-2 control-label">Existing Ailments</form:label>
					<div class="col-sm-6">
						<form:input path="existingAilments" value="${existingAilments}" cssClass="form-control"
							placeholder="e.g. Artharitis, spondylitis" maxlength="200"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="existingAilments" cssClass="text-danger"
							class="control-label" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="allergies" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="allergies" cssClass="col-sm-2 control-label">Allergies</form:label>
					<div class="col-sm-6">
						<form:input path="allergies" value="${allergies}" cssClass="form-control"
							placeholder="e.g. Dust, Antibiotics" maxlength="200"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="allergies" cssClass="text-danger"
							class="control-label" />
					</div>
				</div>
				</spring:bind>
				<hr />
				
				<spring:bind path="email" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
					<div class="col-sm-6">
						<form:input path="email" value="${email}" cssClass="form-control"
							placeholder="e.g. email@gmail.com" maxlength="150"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="email" cssClass="text-danger"
							class="control-label" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="mobile" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="mobile" cssClass="col-sm-2 control-label">Mobile Number</form:label>
					<div class="col-sm-6">
						<form:input path="mobile" value="${mobile}"
							cssClass="form-control" placeholder="10 Digit Mobile Number"
							maxlength="10" />
					</div>
					<div class="col-sm-4">
						<form:errors path="mobile" cssClass="text-danger" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="occupation" >
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="occupation" cssClass="col-sm-2 control-label">Occupation</form:label>
					<div class="col-sm-6">
						<form:input path="occupation" value="${occupation}"
							cssClass="form-control" placeholder="e.g. Field Engineer"
							maxlength="120"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="occupation" cssClass="text-danger" />
					</div>
				</div>
				</spring:bind>
				
				<hr />
				
				<div class="form-group">
					<form:label path="address.apartment"
						cssClass="col-sm-2 control-label">Apartment</form:label>
					<div class="col-sm-6">
						<form:input path="address.apartment" value="${address.apartment}"
							cssClass="form-control" placeholder="Apartment No and Building" maxlength="150"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="address.apartment" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="address.street"
						cssClass="col-sm-2 control-label">Street</form:label>
					<div class="col-sm-6">
						<form:input path="address.street" value="${address.street}"
							cssClass="form-control" placeholder="Street" maxlength="120"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="address.street" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="address.area"
						cssClass="col-sm-2 control-label">Locality</form:label>
					<div class="col-sm-6">
						<form:input path="address.area" value="${address.area}"
							cssClass="form-control" placeholder="Locality" maxlength="120"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="address.area" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="address.city"
						cssClass="col-sm-2 control-label">City</form:label>
					<div class="col-sm-6">
						<form:input path="address.city" value="${address.city}"
							cssClass="form-control" placeholder="City" maxlength="120"/>
					</div>
					<div class="col-sm-4">
						<form:errors path="address.city" cssClass="text-danger" />
					</div>
				</div>
			
				<hr />				

				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<button value="Reset" class="btn btn-default ">Reset</button>
						<input type="submit" value="Register"
							class="btn btn-success" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
