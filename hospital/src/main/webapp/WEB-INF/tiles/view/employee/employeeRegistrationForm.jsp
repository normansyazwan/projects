<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h3>Employee Registration Form</h3>
</div>
	
	<c:if test="${param.status ne null}">
		<p class="bg-success">${param.status}: Record saved successfully. Employee Id is &nbsp; ${param.patientId}</p>
	</c:if>
	
	<form:form method="POST" commandName="employee" cssClass="form-horizontal">
		
		<c:choose>
			<c:when test="${employee.personId > 0}">
				<div class="form-group">
					<form:label path="personId" cssClass="col-sm-2 control-label">Employee Id:</form:label>
					<div class="col-sm-10">${employee.personId}</div>
					<form:hidden path="personId" />
				</div>
			</c:when>
			<c:otherwise>
				
			</c:otherwise>
		</c:choose>
		
		<div class="form-group">
			<form:label path="firstName" cssClass="col-sm-2 control-label">Employee Name:</form:label>
			<div class="col-sm-3">
				<form:input path="firstName" value="${firstName}" cssClass="form-control" placeholder="First Name"/>
			</div>
			<div class="col-sm-3">
				<form:input path="lastName" value="${lastName}" cssClass="form-control" placeholder="Last Name"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="firstName" cssClass="text-danger" class="control-label"/>
			</div>			
		</div>
		<div class="form-group">
			<form:label path="gender" cssClass="col-sm-2 control-label">Gender</form:label>
			<div class="col-sm-6">
				<label class="radio-inline">
  					<form:radiobutton path="gender" value="Male"/> Male
				</label>
				<label class="radio-inline">
  					<form:radiobutton path="gender" value="Female" /> Female
				</label>
			</div>
			<div class="col-sm-4">
				<form:errors path="gender" cssClass="text-danger" />
			</div>			
		</div>
		<div class="form-group">
			<form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date Of Birth</form:label>
			<div class="col-sm-6">
				<fmt:formatDate value="${employee.dateOfBirth}" var="dateString"	pattern="dd/MM/yyyy" /> 
				<form:input path="dateOfBirth"	value="${dateString}"  cssClass="form-control" placeholder="dd/MM/yyyy"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="dateOfBirth" cssClass="text-danger" />
			</div>				
		</div>
		<div class="form-group">
			<form:label path="dateOfJoining" cssClass="col-sm-2 control-label">Date Of Joining</form:label>
			<div class="col-sm-6">
				<fmt:formatDate value="${employee.dateOfJoining}" var="joiningDateString"	pattern="dd/MM/yyyy" /> 
				<form:input path="dateOfJoining" value="${joiningDateString}"  cssClass="form-control" placeholder="dd/MM/yyyy"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="dateOfJoining" cssClass="text-danger" />
			</div>				
		</div>
		<div class="form-group">
			<form:label path="designation" cssClass="col-sm-2 control-label">Designation</form:label>
			<div class="col-sm-6">
				<form:input path="designation" value="${employee.designation}"  cssClass="form-control" placeholder="e.g. Doctor"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="designation" cssClass="text-danger" />
			</div>				
		</div>
		<div class="form-group">
			<form:label path="comments" cssClass="col-sm-2 control-label">Comments</form:label>
			<div class="col-sm-6">
			<form:textarea path="comments"
						value="${comments}" cssClass="form-control" placeholder="Comments..." 
						rows="4" cols="50" />
			</div>
			<div class="col-sm-4">
				<form:errors path="comments" cssClass="text-danger" class="control-label"/>
			</div>				
		</div>
		<hr/>
		<div class="form-group">
			<form:label path="dateOfRelieving" cssClass="col-sm-2 control-label">Date Of Relieving</form:label>
			<div class="col-sm-6">
				<fmt:formatDate value="${employee.dateOfRelieving}" var="dateOfRelievingString"	pattern="dd/MM/yyyy" /> 
				<form:input path="dateOfRelieving" value="${dateOfRelievingString}"  cssClass="form-control" placeholder="dd/MM/yyyy"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="dateOfRelieving" cssClass="text-danger" />
			</div>				
		</div>
		
		<hr/>
		<div class="form-group">
			<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-6">
			<form:input path="email"
						value="${email}" cssClass="form-control" placeholder="e.g. email@gmail.com" />
			</div>
			<div class="col-sm-4">
				<form:errors path="email" cssClass="text-danger" class="control-label"/>
			</div>				
		</div>
		<div class="form-group">
			<form:label path="mobile" cssClass="col-sm-2 control-label">Mobile Number</form:label>
			<div class="col-sm-6">
			<form:input path="mobile"
						value="${mobile}" cssClass="form-control" placeholder="10 Digit Mobile Number" maxlength="10"/>
			</div>
			<div class="col-sm-4">
				<form:errors path="mobile" cssClass="text-danger" />
			</div>			
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

