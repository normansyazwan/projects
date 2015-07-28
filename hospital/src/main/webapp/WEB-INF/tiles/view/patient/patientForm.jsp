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
	
		<form:errors path="*" cssClass="text-danger" ></form:errors>
		
		<c:choose>
			<c:when test="${patient.personId > 0}">
				<div class="form-group">
					<form:label path="personId" cssClass="col-sm-2 control-label">Patient Id:</form:label>
					<div class="col-sm-10">${patient.personId}</div>
				</div>
			</c:when>
			<c:otherwise>
				
			</c:otherwise>
		</c:choose>
		
		<div class="form-group">
			<form:label path="firstName" cssClass="col-sm-2 control-label">Patient Name:</form:label>
			<div class="col-sm-3">
				<form:input path="firstName" value="${firstName}" cssClass="form-control" placeholder="First Name"/>
			</div>
			<div class="col-sm-3">
				<form:input path="lastName" value="${lastName}" cssClass="form-control" placeholder="Last Name"/>
			</div>
			<div class="col-sm-4">.......</div>			
		</div>
		<div class="form-group">
			<form:label path="gender" cssClass="col-sm-2 control-label">Gender</form:label>
			<div class="col-sm-6">
				<label class="radio-inline">
  					<form:radiobutton path="gender" value="Male"/> Male
				</label>
				<label class="radio-inline">
  					<form:radiobutton path="gender" value="Female" /> Female -- ${gender} --
				</label>
			</div>
			<div class="col-sm-4"></div>			
		</div>
		<div class="form-group">
			<form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
			<div class="col-sm-6">
				<fmt:formatDate value="${dateOfBirth}" var="dateString"	pattern="dd/MM/yyyy" /> 
				<form:input path="dateOfBirth"	value="${dateString}"  cssClass="form-control" placeholder="dd/MM/yyyy"/>
			</div>
			<div class="col-sm-4"></div>				
		</div>
		<div class="form-group">
			<form:label path="bloodGroup" cssClass="col-sm-2 control-label">Blood Group</form:label>
			<div class="col-sm-6">
			<form:input path="bloodGroup"
						value="${bloodGroup}" cssClass="form-control" placeholder="Blood Group" />
			</div>
			<div class="col-sm-4"></div>				
		</div>
		<div class="form-group">
			<form:label path="existingAilments" cssClass="col-sm-2 control-label">Existing Ailments</form:label>
			<div class="col-sm-6">
			<form:input path="existingAilments"
						value="${existingAilments}" cssClass="form-control" placeholder="Diabities, High BP" />
			</div>
			<div class="col-sm-4"></div>				
		</div>
		<div class="form-group">
			<form:label path="allergies" cssClass="col-sm-2 control-label">Allergies</form:label>
			<div class="col-sm-6">
			<form:input path="allergies"
						value="${allergies}" cssClass="form-control" placeholder="Drug Allergies" />
			</div>
			<div class="col-sm-4"></div>				
		</div>
		<div class="form-group">
			<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-6">
			<form:input path="email"
						value="${email}" cssClass="form-control" placeholder="Email" />
			</div>
			<div class="col-sm-4"></div>				
		</div>
		<div class="form-group">
			<form:label path="mobile" cssClass="col-sm-2 control-label">Mobile Number</form:label>
			<div class="col-sm-6">
			<form:input path="mobile"
						value="${mobile}" cssClass="form-control" placeholder="Mobile Number" maxlength="10"/>
			</div>
			<div class="col-sm-4"></div>			
		</div>
		<div class="form-group">
			<form:label path="phone" cssClass="col-sm-2 control-label">Landline Phone Number</form:label>
			<div class="col-sm-6">
			<form:input path="phone"
						value="${phone}" cssClass="form-control" placeholder="Landline Phone No" />
			</div>
			<div class="col-sm-4"></div>			
		</div>
		<hr/>
		<div class="form-group">
			<form:label path="address.apartment" cssClass="col-sm-2 control-label">Apartment</form:label>
			<div class="col-sm-6">
			<form:input path="address.apartment"
						value="${address.apartment}" cssClass="form-control" placeholder="Apartment No and Building" />
			</div>			
			<div class="col-sm-4"></div>
		</div>
		<div class="form-group">
			<form:label path="address.street" cssClass="col-sm-2 control-label">Street</form:label>
			<div class="col-sm-6">
			<form:input path="address.street"
						value="${address.street}" cssClass="form-control" placeholder="Street" />
			</div>
			<div class="col-sm-4"></div>			
		</div>
		<div class="form-group">
			<form:label path="address.area" cssClass="col-sm-2 control-label">Area</form:label>
			<div class="col-sm-6">
			<form:input path="address.area"
						value="${address.area}" cssClass="form-control" placeholder="Area" />
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-2">
			</div>
			<div class="col-sm-10">
				<button value="Reset" class="btn btn-default ">Reset</button>
				<input type="submit" value="Save" class="btn btn-primary"/>
			</div>
		</div>
	</form:form>

