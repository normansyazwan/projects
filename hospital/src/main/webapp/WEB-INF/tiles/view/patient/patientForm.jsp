<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<h3>Patient Registration Form</h3>
	
	<c:if test="${param.status ne null}">
		<p class="bg-success">${param.status}: Record saved successfully. Patient Id is &nbsp; ${param.patientId}</p>
	</c:if>
	
	<form:form action="add" method="POST" commandName="patient" cssClass="form-horizontal">
		
		<div class="form-group">
			<form:label path="personId" cssClass="col-sm-2 control-label">Patient Id:</form:label>
			<div class="col-sm-10">
			<form:input path="personId" readonly="true"
						value="${personId}" cssClass="form-control" placeholder="Patient Id" />
			</div>			
		</div>
		<div class="form-group">
			<form:label path="firstName" cssClass="col-sm-2 control-label">Patient Name:</form:label>
			<div class="col-sm-5">
				<form:input path="firstName" value="${firstName}" cssClass="form-control" placeholder="First Name"/>
			</div>
			<div class="col-sm-5">
			<form:input path="lastName" value="${lastName}" cssClass="form-control" placeholder="Last Name"/>
			</div>			
		</div>
		<div class="form-group">
			<form:label path="gender" cssClass="col-sm-2 control-label">Gender</form:label>
			<div class="col-sm-10">
				<label class="radio-inline">
  					<input type="radio" name="genderOptions" id="genderMale" value="Male"> Male
				</label>
				<label class="radio-inline">
  					<input type="radio" name="genderOptions" id="genderFemale" value="Female"> Female
				</label>
			</div>			
		</div>
		<div class="form-group">
			<form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
			<div class="col-sm-10">
			<fmt:formatDate value="${dateOfBirth}" var="dateString"
						pattern="dd/MM/yyyy" /> <form:input path="dateOfBirth"
						value="${dateString}"  cssClass="form-control"/>
			</div>			
		</div>
		<div class="form-group">
			<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-10">
			<form:input path="email"
						value="${email}" cssClass="form-control" placeholder="Email" />
			</div>			
		</div>
		<div class="form-group">
			<form:label path="mobile" cssClass="col-sm-2 control-label">Mobile Number</form:label>
			<div class="col-sm-10">
			<form:input path="mobile"
						value="${mobile}" cssClass="form-control" placeholder="Mobile Number" maxlength="10"/>
			</div>			
		</div>
		<div class="form-group">
			<form:label path="phone" cssClass="col-sm-2 control-label">Landline Phone Number</form:label>
			<div class="col-sm-10">
			<form:input path="phone"
						value="${phone}" cssClass="form-control" placeholder="Landline Phone No" />
			</div>			
		</div>
		<hr/>
		<div class="form-group">
			<form:label path="address.apartment" cssClass="col-sm-2 control-label">Apartment</form:label>
			<div class="col-sm-10">
			<form:input path="address.apartment"
						value="${address.apartment}" cssClass="form-control" placeholder="Apartment No and Building" />
			</div>			
		</div>
		<div class="form-group">
			<form:label path="address.street" cssClass="col-sm-2 control-label">Street</form:label>
			<div class="col-sm-10">
			<form:input path="address.street"
						value="${address.street}" cssClass="form-control" placeholder="Street" />
			</div>			
		</div>
		<div class="form-group">
			<form:label path="address.area" cssClass="col-sm-2 control-label">Area</form:label>
			<div class="col-sm-10">
			<form:input path="address.area"
						value="${address.area}" cssClass="form-control" placeholder="Area" />
			</div>			
		</div>
		<div class="form-group">
			<div class="col-sm-2">
			</div>
			<div class="col-sm-1">
			<button value="Reset" class="btn btn-default ">Reset</button>
			</div>
			<div class="col-sm-1">
			<input type="submit" value="Save" class="btn btn-primary"/>
			</div>
			<div class="col-sm-8"></div>
		</div>
	</form:form>

